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

import com.guitar.management.model.GiaoVien;
import com.guitar.management.service.GiaoVienService;
import com.guitar.management.service.UserService;

@ExtendWith(MockitoExtension.class)
class GiaoVienControllerTest {

  @Mock
  GiaoVienService giaoVienService;

  @Mock
  UserService userService;

  @InjectMocks
  GiaoVienController controller;

  @BeforeEach
  void setUp() {
    // Mockito will inject mocks
  }

  @Test
  void listGiaoVien_returnsListViewAndModel() {
    List<GiaoVien> sample = List.of(new GiaoVien());
    when(giaoVienService.findAll()).thenReturn(sample);

    Model model = new ConcurrentModel();
    String view = controller.listGiaoVien(model);

    assertEquals("giaovien/list", view);
    assertSame(sample, model.getAttribute("giaoVienList"));
  }

  @Test
  void showAddForm_returnsAddView() {
    Model model = new ConcurrentModel();
    String view = controller.showAddForm(model);
    assertEquals("giaovien/add", view);
    assertNotNull(model.getAttribute("giaoVien"));
  }

  @Test
  void saveGiaoVien_callsServiceAndRedirects() {
    GiaoVien gv = new GiaoVien();
    // no nested User -> controller should call giaoVienService.save
    String view = controller.saveGiaoVien(gv);
    verify(giaoVienService).save(gv);
    assertEquals("redirect:/giaovien", view);
  }
}
