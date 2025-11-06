package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.guitar.management.model.GiaoVien;

@DataJpaTest
class GiaoVienRepositoryTest {

  @Autowired
  GiaoVienRepository repo;

  @Test
  void addAndGetById() {
    GiaoVien gv = new GiaoVien();
    gv.setTen("A");
    gv.setTuoi(30);
    gv.setChuyenMon("Guitar");
    GiaoVien saved = repo.save(gv);

    Optional<GiaoVien> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("A", found.get().getTen());
  }

  @Test
  void updateGiaoVien() {
    GiaoVien gv = new GiaoVien();
    gv.setTen("A");
    gv.setTuoi(30);
    gv.setChuyenMon("Guitar");
    GiaoVien saved = repo.save(gv);

    saved.setTen("B");
    saved.setTuoi(35);
    repo.save(saved);

    Optional<GiaoVien> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("B", found.get().getTen());
    assertEquals(35, found.get().getTuoi());
  }

  @Test
  void deleteGiaoVien() {
    GiaoVien gv = new GiaoVien();
    gv.setTen("A");
    gv.setTuoi(30);
    GiaoVien saved = repo.save(gv);

    repo.deleteById(saved.getId());
    Optional<GiaoVien> found = repo.findById(saved.getId());
    assertFalse(found.isPresent());
  }
}
