// File: src/main/java/com/guitar/management/controller/KhoaHocController.java
package com.guitar.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.KhoaHoc;
import com.guitar.management.service.KhoaHocService; // <-- GỌI SERVICE
import com.guitar.management.service.GiaoVienService; // Cần để lấy danh sách GV
import java.util.List;

@Controller
@RequestMapping("/khoahoc")
public class KhoaHocController {

    @Autowired
    private KhoaHocService khoaHocService;
    @Autowired
    private GiaoVienService giaoVienService; // Cần để chọn giáo viên

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
        return "khoahoc/add";
    }

    @PostMapping("/save")
    public String saveKhoaHoc(@ModelAttribute KhoaHoc khoaHoc, @RequestParam("giaoVienId") Long giaoVienId) {
        // Dùng hàm save đặc biệt trong Service để gán giáo viên
        khoaHocService.save(khoaHoc, giaoVienId);
        return "redirect:/khoahoc";
    }

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        KhoaHoc khoaHoc = khoaHocService.findById(id);
        model.addAttribute("khoaHoc", khoaHoc);
        model.addAttribute("listGiaoVien", giaoVienService.findAll());
        return "khoahoc/edit";
    }

    @PostMapping("/update/{id}")
    public String updateKhoaHoc(@PathVariable Long id, @ModelAttribute KhoaHoc khoaHoc,
            @RequestParam("giaoVienId") Long giaoVienId) {
        khoaHoc.setId(id);
        khoaHocService.save(khoaHoc, giaoVienId);
        return "redirect:/khoahoc";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteKhoaHoc(@PathVariable Long id) {
        khoaHocService.deleteById(id);
        return "redirect:/khoahoc";
    }
}