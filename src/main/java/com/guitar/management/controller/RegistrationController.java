//File này hiển thị form đăng ký ra trình duyệt và nhận dữ liệu người dùng nhập vào.

package com.guitar.management.controller;

import com.guitar.management.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationOptions() {
        return "register/options";
    }

    // Chỉ cho phép HỌC VIÊN đăng ký công khai
    @GetMapping("/register/hocvien")
    public String showHocVienRegisterForm() {
        return "register/hocvien-form";
    }

    @PostMapping("/register/hocvien")
    public String processHocVienRegistration(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String ten,
            @RequestParam String email,
            @RequestParam String sdt,
            RedirectAttributes redirect) {
        try {
            userService.registerNewHocVien(username.trim(), password, ten.trim(), email.trim(), sdt.trim());
            redirect.addFlashAttribute("successMessage", "Đăng ký học viên thành công");
            return "redirect:/register/success";
        } catch (IllegalArgumentException e) {
            redirect.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/register/hocvien";
        }
    }

    @GetMapping("/register/success")
    public String showRegistrationSuccess(Model model) {
        return "register/success";
    }
}