package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.guitar.management.model.HocVien;
import com.guitar.management.repository.HocVienRepository;

@Controller
public class HocVienController {

    private final HocVienRepository repo = new HocVienRepository();

    @GetMapping("/hocvien")
    public String listHocVien(Model model) {
        model.addAttribute("hocvienList", repo.getAllHocVien());
        return "hocvien/list";
    }

    @GetMapping("/hocvien/add")
    public String addHocVien(Model model) {
        model.addAttribute("hocVien", new HocVien(0, "", "", ""));
        return "hocvien/add";
    }

    @PostMapping("/hocvien/save")
    public String saveHocVien(@ModelAttribute HocVien hocVien) {
        int id = repo.getAllHocVien().size() + 1;
        hocVien.setId(id);
        repo.addHocVien(hocVien);
        return "redirect:/hocvien";
    }

    @GetMapping("/hocvien/edit/{id}")
    public String editHocVien(@PathVariable int id, Model model) {
        HocVien hv = repo.getHocVienById(id);
        model.addAttribute("hocVien", hv);
        return "hocvien/edit";
    }

    @PostMapping("/hocvien/update")
    public String updateHocVien(@ModelAttribute HocVien hocVien) {
        repo.updateHocVien(hocVien);
        return "redirect:/hocvien";
    }

    @GetMapping("/hocvien/delete/{id}")
    public String deleteHocVien(@PathVariable int id) {
        repo.deleteHocVien(id);
        return "redirect:/hocvien";
    }
}