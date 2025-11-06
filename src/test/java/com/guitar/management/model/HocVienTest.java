package com.guitar.management.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HocVienTest {

  @Test
  void gettersAndSetters_work() {
    HocVien hv = new HocVien();
    hv.setTen("Nguyen Van A");
    hv.setEmail("a@gmail.com");
    hv.setSoDienThoai("0123456789");
    hv.setLevel(1);

    assertEquals("Nguyen Van A", hv.getTen());
    assertEquals("a@gmail.com", hv.getEmail());
    assertEquals("0123456789", hv.getSoDienThoai());
    assertEquals(1, hv.getLevel());
  }
}
