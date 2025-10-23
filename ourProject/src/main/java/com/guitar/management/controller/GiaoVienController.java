package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.guitar.management.model.GiaoVien;
import com.guitar.management.repository.GiaoVienRepository;

@Controller
public class GiaoVienController {

    private final GiaoVienRepository repo = new GiaoVienRepository();

    @GetMapping("/giaovien")
    public String listGiaoVien(Model model) {
        model.addAttribute("giaovienList", repo.getAllGiaoVien());
        return "giaovien/list";
    }

    @GetMapping("/giaovien/add")
    public String addGiaoVien(Model model) {
        model.addAttribute("giaoVien", new GiaoVien(0, "", 18, ""));
        return "giaovien/add";
    }

    @PostMapping("/giaovien/save")
    public String saveGiaoVien(@ModelAttribute GiaoVien giaoVien) {
        int id = repo.getAllGiaoVien().size() + 1;
        giaoVien.setId(id);
        repo.addGiaoVien(giaoVien);
        return "redirect:/giaovien";
    }

    @GetMapping("/giaovien/edit/{id}")
    public String editGiaoVien(@PathVariable int id, Model model) {
        GiaoVien gv = repo.getGiaoVienById(id);
        model.addAttribute("giaoVien", gv);
        return "giaovien/edit";
    }

    @PostMapping("/giaovien/update")
    public String updateGiaoVien(@ModelAttribute GiaoVien giaoVien) {
        repo.updateGiaoVien(giaoVien);
        return "redirect:/giaovien";
    }

    @GetMapping("/giaovien/delete/{id}")
    public String deleteGiaoVien(@PathVariable int id) {
        repo.deleteGiaoVien(id);
        return "redirect:/giaovien";
    }
}