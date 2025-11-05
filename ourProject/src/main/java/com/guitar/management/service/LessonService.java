// File: src/main/java/com/guitar/management/service/LessonService.java
package com.guitar.management.service;

import com.guitar.management.model.Lesson;
import com.guitar.management.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    // --- CRUD cơ bản cho Lesson ---

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson findById(Long id) {
        return lessonRepository.findById(id).orElse(null);
    }

    // Hàm save này sẽ được gọi từ KhoaHocService (addLessonToCourse)
    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }
}