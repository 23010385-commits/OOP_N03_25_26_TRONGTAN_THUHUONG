package com.guitar.management.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;

import com.guitar.management.model.KhoaHoc;
import com.guitar.management.service.GiaoVienService;
import com.guitar.management.service.KhoaHocService;

class KhoaHocControllerTest {

  @Test
  void listKhoaHoc_returnsListViewAndModelHasList() {
    KhoaHocService khoaHocService = mock(KhoaHocService.class);
    GiaoVienService giaoVienService = mock(GiaoVienService.class);
    when(khoaHocService.findAll()).thenReturn(Arrays.asList(new KhoaHoc()));

    KhoaHocController controller = new KhoaHocController(khoaHocService, giaoVienService);
    Model model = new ConcurrentModel();
    String view = controller.listKhoaHoc(null, model);

    assertEquals("khoahoc/list", view);
    assertNotNull(model.getAttribute("listKhoaHoc"));
  }

  @Test
  void showAddForm_returnsAddViewWithModelAttribute() {
    KhoaHocService khoaHocService = mock(KhoaHocService.class);
    GiaoVienService giaoVienService = mock(GiaoVienService.class);

    KhoaHocController controller = new KhoaHocController(khoaHocService, giaoVienService);
    Model model = new ConcurrentModel();
    String view = controller.showAddForm(model);

    assertEquals("khoahoc/add", view);
    assertNotNull(model.getAttribute("khoaHoc"));
    assertNotNull(model.getAttribute("listGiaoVien"));
  }

  @Test
  void saveKhoaHoc_redirectsToList() {
    KhoaHocService khoaHocService = mock(KhoaHocService.class);
    GiaoVienService giaoVienService = mock(GiaoVienService.class);

    KhoaHocController controller = new KhoaHocController(khoaHocService, giaoVienService);
    KhoaHoc kh = new KhoaHoc();
    String view = controller.saveKhoaHoc(kh, null);

    assertEquals("redirect:/khoahoc", view);
    verify(khoaHocService).save(kh);
  }
}
