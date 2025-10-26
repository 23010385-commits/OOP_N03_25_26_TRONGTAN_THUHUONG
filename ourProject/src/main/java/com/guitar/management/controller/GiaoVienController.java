// File: src/main/java/com/guitar/management/controller/GiaoVienController.java
package com.guitar.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.GiaoVien;
import com.guitar.management.service.GiaoVienService; // <-- GỌI SERVICE
import java.util.List;

@Controller
@RequestMapping("/giaovien") // Đặt đường dẫn chung
public class GiaoVienController {

    // 1. KHÔNG DÙNG "new Repository()" (SAI)
    // private final GiaoVienRepository repo = new GiaoVienRepository();

    // 2. YÊU CẦU SPRING "TIÊM" SERVICE VÀO
    @Autowired
    private GiaoVienService giaoVienService;

    // --- 1. READ (ĐỌC) ---
    @GetMapping("")
    public String listGiaoVien(Model model) {
        List<GiaoVien> listGiaoVien = giaoVienService.findAll(); // Gọi Service
        model.addAttribute("listGiaoVien", listGiaoVien);
        return "giaovien/list";
    }

    // --- 2. CREATE (TẠO) ---
    // Bước 2a: Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("giaoVien", new GiaoVien());
        return "giaovien/add";
    }

    // Bước 2b: Xử lý nút "Lưu" từ form
    @PostMapping("/save")
    public String saveGiaoVien(@ModelAttribute GiaoVien giaoVien) {
        giaoVienService.save(giaoVien); // Gọi Service
        return "redirect:/giaovien"; // Quay về trang danh sách
    }

    // --- 3. UPDATE (SỬA) ---
    // Bước 3a: Hiển thị form sửa (dùng Long thay vì int)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        GiaoVien giaoVien = giaoVienService.findById(id); // Gọi Service
        model.addAttribute("giaoVien", giaoVien);
        return "giaovien/edit";
    }

    // Bước 3b: Xử lý nút "Cập nhật" (tách riêng, không dùng chung hàm /save)
    @PostMapping("/update/{id}")
    public String updateGiaoVien(@PathVariable Long id, @ModelAttribute GiaoVien giaoVien) {
        giaoVien.setId(id); // Gán ID vào đối tượng để Service biết đây là UPDATE
        giaoVienService.save(giaoVien); // Gọi Service
        return "redirect:/giaovien";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteGiaoVien(@PathVariable Long id) {
        giaoVienService.deleteById(id); // Gọi Service
        return "redirect:/giaovien";
    }
}