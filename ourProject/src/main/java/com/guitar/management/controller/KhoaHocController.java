// File: src/main/java/com/guitar/management/controller/KhoaHocController.java
package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.KhoaHoc;
import com.guitar.management.service.KhoaHocService; // <-- GỌI SERVICE
import com.guitar.management.service.GiaoVienService; // Cần để lấy danh sách GV
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {

    private final KhoaHocService khoaHocService;
    private final GiaoVienService giaoVienService; // Cần để chọn giáo viên

    // -> constructor injection
    public KhoaHocController(KhoaHocService khoaHocService, GiaoVienService giaoVienService) {
        this.khoaHocService = khoaHocService;
        this.giaoVienService = giaoVienService;
    }

    // --- 1. READ (ĐỌC) ---
    @GetMapping("")
    public String listKhoaHoc(Model model) {
        List<KhoaHoc> listKhoaHoc = khoaHocService.findAll();
        model.addAttribute("listKhoaHoc", listKhoaHoc);
        return "khoahoc/list";
    }

    // --- 2. CREATE (TẠO) ---
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("khoaHoc", new KhoaHoc());
        // Gửi danh sách giáo viên sang view để người dùng chọn
        model.addAttribute("listGiaoVien", giaoVienService.findAll());
        // canonical attribute used across templates
        model.addAttribute("giaoVienList", giaoVienService.findAll());
        return "khoahoc/add";
    }

    @PostMapping("/save")
    public String saveKhoaHoc(@ModelAttribute KhoaHoc khoaHoc,
            @RequestParam(name = "giaoVienId", required = false) Long giaoVienId) {
        if (giaoVienId != null) {
            khoaHocService.save(khoaHoc, giaoVienId);
        } else {
            khoaHocService.save(khoaHoc);
        }
        return "redirect:/khoahoc";
    }

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        KhoaHoc khoaHoc = khoaHocService.findById(id);
        model.addAttribute("khoaHoc", khoaHoc);
        model.addAttribute("listGiaoVien", giaoVienService.findAll());
        model.addAttribute("giaoVienList", giaoVienService.findAll());
        return "khoahoc/edit";
    }

    @PostMapping("/update/{id}")
    public String updateKhoaHoc(@PathVariable Long id, @ModelAttribute KhoaHoc khoaHoc,
            @RequestParam(name = "giaoVienId", required = false) Long giaoVienId) {
        khoaHoc.setId(id);
        if (giaoVienId != null) {
            khoaHocService.save(khoaHoc, giaoVienId);
        } else {
            khoaHocService.save(khoaHoc);
        }
        return "redirect:/khoahoc";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteKhoaHoc(@PathVariable Long id) {
        khoaHocService.deleteById(id);
        return "redirect:/khoahoc";
    }

    // --- CHI TIẾT KHÓA HỌC (HIỂN THỊ LESSONS) ---
    @GetMapping("/detail/{id}")
    public String detailKhoaHoc(@PathVariable Long id, Model model) {
        // Lưu ý: nếu KhoaHoc.lessons là LAZY, đảm bảo KhoaHocService.findById tải
        // lessons (EntityGraph hoặc @Transactional)
        KhoaHoc khoaHoc = khoaHocService.findById(id);
        model.addAttribute("khoaHoc", khoaHoc);
        return "khoahoc/detail";
    }

    // --- THÊM BÀI HỌC TRONG TRANG CHI TIẾT ---
    @PostMapping("/{id}/lessons")
    public String addLessonToCourse(@PathVariable("id") Long khoaHocId,
            @RequestParam String title,
            @RequestParam(required = false) String noiDung,
            @RequestParam(defaultValue = "1") int thoiLuong,
            RedirectAttributes redirect) {
        try {
            khoaHocService.addLessonToCourse(khoaHocId, title, noiDung, thoiLuong);
            redirect.addFlashAttribute("successMessage", "Thêm bài học thành công");
        } catch (RuntimeException ex) {
            redirect.addFlashAttribute("errorMessage", ex.getMessage());
        }
        return "redirect:/khoahoc/detail/" + khoaHocId;
    }
}