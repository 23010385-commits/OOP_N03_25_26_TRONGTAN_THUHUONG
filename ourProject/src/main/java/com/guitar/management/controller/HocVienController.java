package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.HocVien;
import com.guitar.management.service.HocVienService; // Gọi service
import java.util.List;

@Controller
@RequestMapping("/hocvien")
public class HocVienController {

    private final HocVienService hocVienService;

    // -> constructor injection
    public HocVienController(HocVienService hocVienService) {
        this.hocVienService = hocVienService;
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
}