package com.guitar.management.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import com.guitar.management.model.Lesson;
import com.guitar.management.service.KhoaHocService;
import com.guitar.management.service.LessonService;

@ExtendWith(MockitoExtension.class)
class LessonCotrollerTest {

  @Mock
  LessonService lessonService;

  @Mock
  KhoaHocService khoaHocService;

  @InjectMocks
  LessonController controller;

  @BeforeEach
  void setUp() {
    // injected by Mockito
  }

  @Test
  void listLesson_returnsListViewAndModel() {
    List<Lesson> sample = List.of(new Lesson());
    when(lessonService.findAll()).thenReturn(sample);

    Model model = new ConcurrentModel();
    String view = controller.listLesson(model);

    assertEquals("lesson/list", view);
    assertSame(sample, model.getAttribute("listLesson"));
  }

  @Test
  void showEditForm_populatesModel() {
    Lesson l = new Lesson();
    when(lessonService.findById(1L)).thenReturn(l);

    Model model = new ConcurrentModel();
    String view = controller.showEditForm(1L, model);
    assertEquals("lesson/edit", view);
    assertSame(l, model.getAttribute("lesson"));
  }

  @Test
  void saveLesson_callsServiceAndRedirects() {
    Lesson l = new Lesson();
    String view = controller.saveLesson(l);
    verify(lessonService).save(l);
    // when no associated khoaHoc -> controller redirects to /lesson
    assertEquals("redirect:/lesson", view);
  }
}
