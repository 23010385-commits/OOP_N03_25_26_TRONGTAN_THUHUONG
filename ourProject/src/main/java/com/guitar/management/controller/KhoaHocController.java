package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.guitar.management.model.KhoaHoc;
import com.guitar.management.repository.KhoaHocRepository;

@Controller
public class KhoaHocController {

    private final KhoaHocRepository repo = new KhoaHocRepository();

    @GetMapping("/khoahoc")
    public String listKhoaHoc(Model model) {
        model.addAttribute("khoaHocList", repo.getAllKhoaHoc());
        return "khoahoc/list";
    }

    @GetMapping("/khoahoc/add")
    public String addKhoaHoc(Model model) {
        model.addAttribute("khoaHoc", new KhoaHoc(0, "", "", null));
        return "khoahoc/add";
    }

    @PostMapping("/khoahoc/save")
    public String saveKhoaHoc(@ModelAttribute KhoaHoc khoaHoc) {
        int id = repo.getAllKhoaHoc().size() + 1;
        khoaHoc.setId(id);
        repo.addKhoaHoc(khoaHoc);
        return "redirect:/khoahoc";
    }

    @GetMapping("/khoahoc/edit/{id}")
    public String editKhoaHoc(@PathVariable int id, Model model) {
        KhoaHoc kh = repo.getKhoaHocById(id);
        model.addAttribute("khoaHoc", kh);
        return "khoahoc/edit";
    }

    @PostMapping("/khoahoc/update")
    public String updateKhoaHoc(@ModelAttribute KhoaHoc khoaHoc) {
        repo.updateKhoaHoc(khoaHoc);
        return "redirect:/khoahoc";
    }

    @GetMapping("/khoahoc/delete/{id}")
    public String deleteKhoaHoc(@PathVariable int id) {
        repo.deleteKhoaHoc(id);
        return "redirect:/khoahoc";
    }
}