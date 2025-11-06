package com.guitar.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.guitar.management.model.HocVien;
import com.guitar.management.model.KhoaHoc;
import com.guitar.management.model.Lesson;
import com.guitar.management.model.HocVienKhoaHoc;

@DataJpaTest
class HVKHRepositoryTest {

  @Autowired
  HocVienKhoaHocRepository repo;

  @Autowired
  HocVienRepository hocVienRepo;

  @Autowired
  KhoaHocRepository khoaHocRepo;

  @Autowired
  LessonRepository lessonRepo;

  @Test
  void addAndGetById() {
    HocVien hv = new HocVien();
    hv.setTen("HV");
    hv.setEmail("hv@example.com");
    hv.setSoDienThoai("0123");
    HocVien savedHv = hocVienRepo.save(hv);

    KhoaHoc kh = new KhoaHoc();
    kh.setTenKhoaHoc("KH");
    kh.setMoTa("d");
    KhoaHoc savedKh = khoaHocRepo.save(kh);

    Lesson l = new Lesson();
    l.setTitle("L");
    l.setNoiDung("nd");
    l.setThoiLuong(10);
    lessonRepo.save(l);

    HocVienKhoaHoc hvkh = new HocVienKhoaHoc();
    hvkh.setHocVien(savedHv);
    hvkh.setKhoaHoc(savedKh);
    hvkh.setNgayDangKy(new Date());
    hvkh.setTrangThai("Dang hoc");
    HocVienKhoaHoc saved = repo.save(hvkh);

    Optional<HocVienKhoaHoc> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("Dang hoc", found.get().getTrangThai());
  }

  @Test
  void updateAndDelete() {
    HocVien hv = new HocVien();
    hv.setTen("HV2");
    hv.setEmail("hv2@example.com");
    hv.setSoDienThoai("0000");
    HocVien savedHv = hocVienRepo.save(hv);

    KhoaHoc kh = new KhoaHoc();
    kh.setTenKhoaHoc("KH2");
    KhoaHoc savedKh = khoaHocRepo.save(kh);

    Lesson l = new Lesson();
    l.setTitle("L2");
    l.setNoiDung("nd");
    l.setThoiLuong(20);
    lessonRepo.save(l);

    HocVienKhoaHoc hvkh = new HocVienKhoaHoc();
    hvkh.setHocVien(savedHv);
    hvkh.setKhoaHoc(savedKh);
    hvkh.setNgayDangKy(new Date());
    hvkh.setTrangThai("Dang hoc");
    HocVienKhoaHoc saved = repo.save(hvkh);

    saved.setTrangThai("Hoan thanh");
    repo.save(saved);

    Optional<HocVienKhoaHoc> found = repo.findById(saved.getId());
    assertTrue(found.isPresent());
    assertEquals("Hoan thanh", found.get().getTrangThai());

    repo.deleteById(saved.getId());
    Optional<HocVienKhoaHoc> after = repo.findById(saved.getId());
    assertFalse(after.isPresent());
  }
}
