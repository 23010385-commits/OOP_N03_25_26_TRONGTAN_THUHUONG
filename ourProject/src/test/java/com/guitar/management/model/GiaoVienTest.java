package com.guitar.management.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GiaoVienTest {

  @Test
  void gettersAndSetters_workAsExpected() {
    GiaoVien gv = new GiaoVien();
    gv.setTen("Nguyen Van A");
    gv.setTuoi(35);
    gv.setChuyenMon("Thanh Nhac");

    assertEquals("Nguyen Van A", gv.getTen());
    assertEquals(35, gv.getTuoi());
    assertEquals("Thanh Nhac", gv.getChuyenMon());

    // dsKhoaHoc should be mutable collection by default
    assertNotNull(gv.getDsKhoaHoc());
    assertTrue(gv.getDsKhoaHoc().isEmpty());
  }
}
