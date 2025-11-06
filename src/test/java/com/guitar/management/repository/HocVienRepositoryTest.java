package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.guitar.management.model.HocVien;

@DataJpaTest
class HocVienRepositoryTest {

  @Autowired
  HocVienRepository repo;

  @Test
  void addAndGetById() {
    HocVien hv = new HocVien();
    hv.setTen("H");
    hv.setEmail("h@example.com");
    hv.setSoDienThoai("0123");
    HocVien saved = repo.save(hv);

    Optional<HocVien> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("H", found.get().getTen());
  }

  @Test
  void updateAndDelete() {
    HocVien hv = new HocVien();
    hv.setTen("H");
    hv.setEmail("h@example.com");
    hv.setSoDienThoai("0123");
    HocVien saved = repo.save(hv);

    saved.setTen("H2");
    saved.setEmail("h2@example.com");
    saved.setSoDienThoai("0123");
    repo.save(saved);

    Optional<HocVien> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("H2", found.get().getTen());

    repo.deleteById(saved.getId());
    Optional<HocVien> afterDelete = repo.findById(saved.getId());
    assertFalse(afterDelete.isPresent());
  }
}
