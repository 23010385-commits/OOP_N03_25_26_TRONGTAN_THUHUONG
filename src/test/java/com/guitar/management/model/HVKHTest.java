package com.guitar.management.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HVKHTest {

  @Test
  void hocVienKhoaHoc_entity_basicBehavior() {
    HocVien gv = new HocVien();
    gv.setTen("Student");

    KhoaHoc kh = new KhoaHoc();
    kh.setTenKhoaHoc("KH1");

    HocVienKhoaHoc hvkh = new HocVienKhoaHoc();
    hvkh.setHocVien(gv);
    hvkh.setKhoaHoc(kh);
    hvkh.setNgayDangKy(new java.util.Date());
    hvkh.setTrangThai("Dang hoc");

    assertEquals(gv, hvkh.getHocVien());
    assertEquals(kh, hvkh.getKhoaHoc());
    assertEquals("Dang hoc", hvkh.getTrangThai());
  }
}
