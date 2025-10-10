package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HocVienController {
    @GetMapping("/hocvien")
    public String listHocVien() {
        return "hocvien/list";
    }

    @GetMapping("/hocvien/add")
    public String addHocVien() {
        return "hocvien/add";
    }

    @GetMapping("/hocvien/edit")
    public String editHocVien() {
        return "hocvien/edit";
    }
}