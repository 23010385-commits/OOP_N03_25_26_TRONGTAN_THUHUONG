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

import com.guitar.management.model.HocVien;
import com.guitar.management.service.HocVienService;

@ExtendWith(MockitoExtension.class)
class HocVienControllerTest {

  @Mock
  HocVienService hocVienService;

  @InjectMocks
  HocVienController controller;

  @BeforeEach
  void setUp() {
    // MockitoExtension will inject mocks into controller
  }

  @Test
  void listHocVien_populatesModelAndReturnsView() {
    List<HocVien> sample = List.of(new HocVien());
    when(hocVienService.findAll()).thenReturn(sample);

    Model model = new ConcurrentModel();
    String view = controller.listHocVien(model);

    assertEquals("hocvien/list", view);
    assertSame(sample, model.getAttribute("listHocVien"));
  }

  @Test
  void showAddForm_returnsAddViewAndModelHasHocVien() {
    Model model = new ConcurrentModel();
    String view = controller.showAddForm(model);
    assertEquals("hocvien/add", view);
    assertNotNull(model.getAttribute("hocVien"));
  }

  @Test
  void saveHocVien_callsServiceAndRedirects() {
    HocVien hv = new HocVien();
    String view = controller.saveHocVien(hv);
    verify(hocVienService).save(hv);
    assertEquals("redirect:/hocvien", view);
  }
}
