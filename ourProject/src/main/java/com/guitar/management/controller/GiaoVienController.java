// File: src/main/java/com/guitar/management/controller/GiaoVienController.java
package com.guitar.management.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.GiaoVien;
import com.guitar.management.service.GiaoVienService;
import java.util.List;

@Controller
@RequestMapping("/giaovien")
public class GiaoVienController {

    private final GiaoVienService giaoVienService;

    // -> constructor injection
    public GiaoVienController(GiaoVienService giaoVienService) {
        this.giaoVienService = giaoVienService;
    }

    // --- ĐÃ SỬA LỖI ---
    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                model.addAttribute("username", userDetails.getUsername());
            } else {
                model.addAttribute("username", String.valueOf(principal));
            }
        } else {
            model.addAttribute("username", "Giáo viên");
        }
        return "giaovien/home";
    }

    // --- 1. READ (ĐỌC) ---
    @GetMapping("")
    public String listGiaoVien(Model model) {
        List<GiaoVien> listGiaoVien = giaoVienService.findAll();
        model.addAttribute("listGiaoVien", listGiaoVien);
        return "giaovien/list";
    }

    // --- 2. CREATE (TẠO) ---
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("giaoVien", new GiaoVien());
        return "giaovien/add";
    }

    @PostMapping("/save")
    public String saveGiaoVien(@ModelAttribute GiaoVien giaoVien) {
        giaoVienService.save(giaoVien);
        return "redirect:/giaovien";
    }

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        GiaoVien giaoVien = giaoVienService.findById(id);
        model.addAttribute("giaoVien", giaoVien);
        return "giaovien/edit";
    }

    @PostMapping("/update/{id}")
    public String updateGiaoVien(@PathVariable Long id, @ModelAttribute GiaoVien giaoVien) {
        giaoVien.setId(id);
        giaoVienService.save(giaoVien);
        return "redirect:/giaovien";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteGiaoVien(@PathVariable Long id) {
        giaoVienService.deleteById(id);
        return "redirect:/giaovien";
    }
}