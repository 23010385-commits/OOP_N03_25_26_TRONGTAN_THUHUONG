//File này hiển thị form đăng ký ra trình duyệt và nhận dữ liệu người dùng nhập vào.

package com.guitar.management.controller;

import com.guitar.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

  @Autowired
  private UserService userService; // Tiêm "bộ não" UserService

  // Khi người dùng vào GET /register
  @GetMapping("/register")
  public String showRegistrationOptions() {
    // Trả về file HTML: /templates/register/options.html
    return "register/options";
  }

  // --- XỬ LÝ ĐĂNG KÝ GIÁO VIÊN ---

  @GetMapping("/register/giaovien")
  public String showGiaoVienRegisterForm() {
    // Trả về file HTML: /templates/register/giaovien-form.html
    return "register/giaovien-form";
  }

  @PostMapping("/register/giaovien")
  public String processGiaoVienRegistration(
      @RequestParam String username, @RequestParam String password,
      @RequestParam String ten, @RequestParam int tuoi,
      @RequestParam String chuyenMon, Model model) {
    try {
      // Gọi Service để đăng ký (Service đã có validation)
      userService.registerNewGiaoVien(username, password, ten, tuoi, chuyenMon);
      return "redirect:/register/success"; // Chuyển đến trang thành công
    } catch (IllegalArgumentException e) {
      // Nếu Service báo lỗi (VD: "Username đã tồn tại!")
      model.addAttribute("errorMessage", e.getMessage());
      return "register/giaovien-form"; // Quay lại form với thông báo lỗi
    }
  }

  // --- XỬ LÝ ĐĂNG KÝ HỌC VIÊN ---

  @GetMapping("/register/hocvien")
  public String showHocVienRegisterForm() {
    return "register/hocvien-form"; // Trả về file HTML
  }

  @PostMapping("/register/hocvien")
  public String processHocVienRegistration(
      @RequestParam String username, @RequestParam String password,
      @RequestParam String ten, @RequestParam String email,
      @RequestParam String sdt, Model model) {
    try {
      userService.registerNewHocVien(username, password, ten, email, sdt);
      return "redirect:/register/success";
    } catch (IllegalArgumentException e) {
      model.addAttribute("errorMessage", e.getMessage());
      return "register/hocvien-form";
    }
  }

  // --- TRANG ĐĂNG KÝ THÀNH CÔNG ---

  @GetMapping("/register/success")
  public String showRegistrationSuccess() {
    return "register/success"; // Trả về file HTML
  }
}