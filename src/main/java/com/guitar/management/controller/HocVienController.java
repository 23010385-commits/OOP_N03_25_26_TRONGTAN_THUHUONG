package com.guitar.management.controller;

import org.springframework.security.core.Authentication; // <-- THÊM IMPORT
import org.springframework.security.core.userdetails.UserDetails; // <-- THÊM IMPORT
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // <-- THÊM IMPORT
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.HocVien;
import com.guitar.management.service.HocVienService;
import java.util.List;

@Controller
@RequestMapping("/hocvien")
public class HocVienController {

    private final HocVienService hocVienService;

    // -> constructor injection
    public HocVienController(HocVienService hocVienService) {
        this.hocVienService = hocVienService;
    }

    // --- ĐÃ SỬA LỖI ---
    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        String username = "Học viên"; // Giá trị mặc định
        String initial = "H"; // Chữ cái đầu mặc định

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                username = userDetails.getUsername();
            } else if (principal != null) {
                username = String.valueOf(principal);
            }

            if (username != null && !username.isEmpty()) {
                initial = username.substring(0, 1).toUpperCase();
            }
        }

        model.addAttribute("username", username);
        model.addAttribute("userInitial", initial); // Gửi chữ cái đầu

        return "hocvien/home"; // Trả về templates/hocvien/home.html
    }

    // --- 1. READ (ĐỌC) ---
    @GetMapping("")
    public String listHocVien(Model model) {
        List<HocVien> listHocVien = hocVienService.findAll();
        model.addAttribute("listHocVien", listHocVien);
        return "hocvien/list";
    }

    // --- 2. CREATE (TẠO) ---
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("hocVien", new HocVien());
        return "hocvien/add";
    }

    @PostMapping("/save")
    public String saveHocVien(@ModelAttribute HocVien hocVien) {
        hocVienService.save(hocVien);
        return "redirect:/hocvien";
    }

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        HocVien hocVien = hocVienService.findById(id);
        model.addAttribute("hocVien", hocVien);
        return "hocvien/edit";
    }

    @PostMapping("/update/{id}")
    public String updateHocVien(@PathVariable Long id, @ModelAttribute HocVien hocVien) {
        hocVien.setId(id);
        hocVienService.save(hocVien);
        return "redirect:/hocvien";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteHocVien(@PathVariable Long id) {
        hocVienService.deleteById(id);
        return "redirect:/hocvien";
    }

    @PostMapping("/delete/{id}")
    public String deleteHocVienPost(@PathVariable Long id) {
        hocVienService.deleteById(id);
        return "redirect:/hocvien";
    }
}