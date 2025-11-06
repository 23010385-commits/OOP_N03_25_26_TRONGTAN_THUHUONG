package com.guitar.management.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LessonTest {

  @Test
  void gettersAndSetters_work() {
    Lesson lesson = new Lesson();
    lesson.setTitle("Guitar Basics");
    lesson.setNoiDung("Learn the basics of guitar");
    lesson.setThoiLuong(60);

    assertEquals("Guitar Basics", lesson.getTitle());
    assertEquals("Learn the basics of guitar", lesson.getNoiDung());
    assertEquals(60, lesson.getThoiLuong());
  }
}
