// File: src/main/java/com/guitar/management/controller/LessonController.java
package com.guitar.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.Lesson;
import com.guitar.management.service.LessonService; // <-- GỌI SERVICE
import com.guitar.management.service.KhoaHocService;
import java.util.List;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;
    @Autowired
    private KhoaHocService khoaHocService; // Cần để chọn khóa học

    // --- 1. READ (ĐỌC) ---
    @GetMapping("")
    public String listLesson(Model model) {
        List<Lesson> listLesson = lessonService.findAll();
        model.addAttribute("listLesson", listLesson);
        return "lesson/list";
    }

    // --- 2. CREATE (TẠO) ---
    // Logic tạo Lesson (addLessonToCourse) đã nằm trong KhoaHocService
    // Bạn nên tạo trang "Thêm bài học" ở bên trong trang chi tiết Khóa học

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        // Gửi danh sách khóa học để có thể đổi bài học sang khóa khác
        model.addAttribute("listKhoaHoc", khoaHocService.findAll());
        return "lesson/edit";
    }

    @PostMapping("/update/{id}")
    public String updateLesson(@PathVariable Long id, @ModelAttribute Lesson lesson) {
        lesson.setId(id);
        lessonService.save(lesson); // Dùng hàm save cơ bản
        return "redirect:/lesson";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteLesson(@PathVariable Long id) {
        lessonService.deleteById(id);
        return "redirect:/lesson";
    }
}