package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LessonController {
    @GetMapping("/lesson")
    public String listLesson() {
        return "lesson/list";
    }

    @GetMapping("/lesson/add")
    public String addLesson() {
        return "lesson/add";
    }

    @GetMapping("/lesson/edit")
    public String editLesson() {
        return "lesson/edit";
    }
}