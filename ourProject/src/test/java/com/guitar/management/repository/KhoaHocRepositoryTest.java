package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.guitar.management.model.KhoaHoc;

@DataJpaTest
class KhoaHocRepositoryTest {

  @Autowired
  KhoaHocRepository repo;

  @Test
  void addAndGetById() {
    KhoaHoc kh = new KhoaHoc();
    kh.setTenKhoaHoc("Guitar Basic");
    kh.setMoTa("desc");
    KhoaHoc saved = repo.save(kh);

    Optional<KhoaHoc> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("Guitar Basic", found.get().getTenKhoaHoc());
  }

  @Test
  void updateKhoaHoc() {
    KhoaHoc kh = new KhoaHoc();
    kh.setTenKhoaHoc("Old");
    kh.setMoTa("d");
    KhoaHoc saved = repo.save(kh);

    saved.setTenKhoaHoc("New Name");
    repo.save(saved);

    Optional<KhoaHoc> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("New Name", found.get().getTenKhoaHoc());
  }

  @Test
  void deleteKhoaHoc() {
    KhoaHoc kh = new KhoaHoc();
    kh.setTenKhoaHoc("ToDelete");
    KhoaHoc saved = repo.save(kh);

    repo.deleteById(saved.getId());
    Optional<KhoaHoc> found = repo.findById(saved.getId());
    assertFalse(found.isPresent());
  }
}
