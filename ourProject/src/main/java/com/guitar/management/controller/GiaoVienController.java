package ourProject.src.main.java.com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GiaoVienController {
    @GetMapping("/giaovien")
    public String listGiaoVien() {
        return "giaovien/list";
    }

    @GetMapping("/giaovien/add")
    public String addGiaoVien() {
        return "giaovien/add";
    }

    @GetMapping("/giaovien/edit")
    public String editGiaoVien() {
        return "giaovien/edit";
    }
}