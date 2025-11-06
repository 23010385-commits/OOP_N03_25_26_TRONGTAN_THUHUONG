// File: src/main/java/com/guitar/management/controller/GiaoVienController.java
package com.guitar.management.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.GiaoVien;
import com.guitar.management.model.User;
import com.guitar.management.service.GiaoVienService; // <-- GỌI SERVICE
import com.guitar.management.service.UserService;
import java.util.List;

@Controller
@RequestMapping("/giaovien")
public class GiaoVienController {

    private final GiaoVienService giaoVienService;
    private final UserService userService;

    // -> constructor injection
    public GiaoVienController(GiaoVienService giaoVienService, UserService userService) {
        this.giaoVienService = giaoVienService;
        this.userService = userService;
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
        List<GiaoVien> listGiaoVien = giaoVienService.findAll(); // Gọi Service
        // expose canonical 'giaoVienList' for templates; keep 'teachers' as an alias
        model.addAttribute("giaoVienList", listGiaoVien);
        model.addAttribute("teachers", listGiaoVien);
        return "giaovien/list";
    }

    // --- 2. CREATE (TẠO) ---
    @GetMapping("/add")
    public String showAddForm(Model model) {
        GiaoVien gv = new GiaoVien();
        // initialize nested User so Thymeleaf can bind user.username / user.password
        gv.setUser(new User());
        model.addAttribute("giaoVien", gv);
        return "giaovien/add";
    }

    @PostMapping("/save")
    public String saveGiaoVien(@ModelAttribute GiaoVien giaoVien) {
        // If nested User provided, use UserService to register (handles hashing and
        // transactional save)
        if (giaoVien.getUser() != null && giaoVien.getUser().getUsername() != null
                && !giaoVien.getUser().getUsername().isBlank() && giaoVien.getUser().getPassword() != null
                && !giaoVien.getUser().getPassword().isBlank()) {
            userService.registerNewGiaoVien(giaoVien.getUser().getUsername().trim(),
                    giaoVien.getUser().getPassword(), giaoVien.getTen(), giaoVien.getTuoi(),
                    giaoVien.getChuyenMon());
        } else {
            // fallback: save GiaoVien only
            giaoVienService.save(giaoVien);
        }
        return "redirect:/giaovien"; // Quay về trang danh sách
    }

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        GiaoVien giaoVien = giaoVienService.findById(id);
        model.addAttribute("giaoVien", giaoVien);
        return "giaovien/edit";
    }

    // Bước 3b: Xử lý nút "Cập nhật" (POST form includes hidden id)
    @PostMapping("/update")
    public String updateGiaoVien(@ModelAttribute GiaoVien giaoVien) {
        // nếu form gửi id trong giaoVien.id thì save sẽ hiểu đây là UPDATE
        if (giaoVien.getId() != null) {
            giaoVienService.save(giaoVien); // Gọi Service (save handles create/update)
        }
        return "redirect:/giaovien";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteGiaoVien(@PathVariable Long id) {
        giaoVienService.deleteById(id);
        return "redirect:/giaovien";
    }
}