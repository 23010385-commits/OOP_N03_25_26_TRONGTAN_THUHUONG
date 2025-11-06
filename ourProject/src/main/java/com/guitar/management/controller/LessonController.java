package com.guitar.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.guitar.management.model.Lesson;
import com.guitar.management.repository.LessonRepository;

@Controller
public class LessonController {

    private final LessonRepository repo = new LessonRepository();

    @GetMapping("/lesson")
    public String listLesson(Model model) {
        model.addAttribute("lessonList", repo.getAllLessons());
        return "lesson/list";
    }

    @GetMapping("/lesson/add")
    public String addLesson(Model model) {
        model.addAttribute("lesson", new Lesson(0, "", "", 0));
        return "lesson/add";
    }

    @PostMapping("/lesson/save")
    public String saveLesson(@ModelAttribute Lesson lesson) {
        int id = repo.getAllLessons().size() + 1;
        lesson.setLessonID(id);
        repo.addLesson(lesson);
        return "redirect:/lesson";
    }

    @GetMapping("/lesson/edit/{id}")
    public String editLesson(@PathVariable int id, Model model) {
        Lesson l = repo.getLessonById(id);
        model.addAttribute("lesson", l);
        return "lesson/edit";
    }

    @PostMapping("/lesson/update")
    public String updateLesson(@ModelAttribute Lesson lesson) {
        repo.updateLesson(lesson.getLessonID(), lesson);
        return "redirect:/lesson";
    }

    @GetMapping("/lesson/delete/{id}")
    public String deleteLesson(@PathVariable int id) {
        repo.deleteLesson(id);
        return "redirect:/lesson";
    }
}