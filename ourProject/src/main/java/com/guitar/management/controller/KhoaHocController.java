package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KhoaHocController {
    @GetMapping("/khoahoc")
    public String listKhoaHoc() {
        return "khoahoc/list";
    }

    @GetMapping("/khoahoc/add")
    public String addKhoaHoc() {
        return "khoahoc/add";
    }

    @GetMapping("/khoahoc/edit")
    public String editKhoaHoc() {
        return "khoahoc/edit";
    }
}