package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.guitar.management.model.Lesson;

@DataJpaTest
class LessonRepositoryTest {

  @Autowired
  LessonRepository repo;

  @Test
  void addAndGetById() {
    Lesson l = new Lesson();
    l.setTitle("Intro");
    l.setNoiDung("nd");
    l.setThoiLuong(60);
    Lesson saved = repo.save(l);

    Optional<Lesson> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("Intro", found.get().getTitle());
  }

  @Test
  void updateLesson_updatesFields() {
    Lesson l = new Lesson();
    l.setTitle("Old");
    l.setNoiDung("nd");
    l.setThoiLuong(45);
    Lesson saved = repo.save(l);

    saved.setTitle("Updated");
    saved.setNoiDung("nd2");
    repo.save(saved);

    Optional<Lesson> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("Updated", found.get().getTitle());
  }

  @Test
  void deleteLesson_removesEntity() {
    Lesson l = new Lesson();
    l.setTitle("ToDel");
    Lesson saved = repo.save(l);

    repo.deleteById(saved.getId());
    Optional<Lesson> found = repo.findById(saved.getId());
    assertFalse(found.isPresent());
  }
}
