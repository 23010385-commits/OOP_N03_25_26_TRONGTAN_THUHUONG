// File: src/main/java/com/guitar/management/controller/LessonController.java
package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.guitar.management.model.Lesson;
import com.guitar.management.service.LessonService;
import com.guitar.management.service.KhoaHocService;
import java.util.List;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;
    private final KhoaHocService khoaHocService; // Cần để chọn khóa học

    // constructor injection (an toàn, dễ test)
    public LessonController(LessonService lessonService, KhoaHocService khoaHocService) {
        this.lessonService = lessonService;
        this.khoaHocService = khoaHocService;
    }

    // --- 1. READ (ĐỌC) ---
    @GetMapping("")
    public String listLesson(Model model) {
        List<Lesson> listLesson = lessonService.findAll();
        model.addAttribute("listLesson", listLesson);
        return "lesson/list";
    }

    // --- 2. CREATE (TẠO) ---
    // Logic tạo Lesson (addLessonToCourse) nằm trong KhoaHocService; khuyến nghị
    // gọi endpoint từ KhoaHocController/detail

    // --- 3. UPDATE (SỬA) ---
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        model.addAttribute("listKhoaHoc", khoaHocService.findAll());
        return "lesson/edit";
    }

    @PostMapping("/update/{id}")
    public String updateLesson(@PathVariable Long id, @ModelAttribute Lesson lesson) {
        lesson.setId(id);
        lessonService.save(lesson);
        return "redirect:/lesson";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    public String deleteLesson(@PathVariable Long id) {
        lessonService.deleteById(id);
        return "redirect:/lesson";
    }
}