// File: src/main/java/com/guitar/management/controller/LessonController.java
package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String showEditForm(@PathVariable Long id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        model.addAttribute("listKhoaHoc", khoaHocService.findAll());
        return "lesson/edit";
    }

    @PostMapping("/update")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String updateLesson(@ModelAttribute Lesson lesson) {
        // If the form didn't include the associated KhoaHoc, preserve it from existing
        // record
        if (lesson.getKhoaHoc() == null && lesson.getId() != null) {
            Lesson existing = lessonService.findById(lesson.getId());
            if (existing != null) {
                lesson.setKhoaHoc(existing.getKhoaHoc());
            }
        }
        lessonService.save(lesson);
        if (lesson.getKhoaHoc() != null && lesson.getKhoaHoc().getId() != null) {
            return "redirect:/khoahoc/detail/" + lesson.getKhoaHoc().getId();
        }
        return "redirect:/lesson";
    }

    // Handle create/save from form (used by lesson/add.html)
    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String saveLesson(@ModelAttribute Lesson lesson) {
        // Preserve association: if form didn't submit khoaHoc, try to keep existing or
        // redirect to lesson list
        if (lesson.getKhoaHoc() == null && lesson.getId() != null) {
            Lesson existing = lessonService.findById(lesson.getId());
            if (existing != null) {
                lesson.setKhoaHoc(existing.getKhoaHoc());
            }
        }
        lessonService.save(lesson);
        if (lesson.getKhoaHoc() != null) {
            Long khId = lesson.getKhoaHoc().getId();
            if (khId != null)
                return "redirect:/khoahoc/detail/" + khId;
        }
        return "redirect:/lesson";
    }

    // --- 4. DELETE (XÓA) ---
    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('GIAOVIEN','ADMIN')")
    public String deleteLesson(@PathVariable Long id) {
        // Try to capture parent course so we can redirect back to it after deletion
        Lesson existing = lessonService.findById(id);
        Long khId = null;
        if (existing != null && existing.getKhoaHoc() != null) {
            khId = existing.getKhoaHoc().getId();
        }
        lessonService.deleteById(id);
        if (khId != null)
            return "redirect:/khoahoc/detail/" + khId;
        return "redirect:/lesson";
    }
}