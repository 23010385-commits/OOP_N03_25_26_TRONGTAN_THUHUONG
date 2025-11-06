// File: src/main/java/com/guitar/management/repository/LessonRepository.java
package com.guitar.management.repository;

import com.guitar.management.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // <-- Báo cho Spring: "Đây là một 'Bean'!"
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    // Để trống
}