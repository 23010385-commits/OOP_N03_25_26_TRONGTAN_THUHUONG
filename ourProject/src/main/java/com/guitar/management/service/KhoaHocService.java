// File: src/main/java/com/guitar/management/service/KhoaHocService.java
package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KhoaHocService {

  @Autowired
  private KhoaHocRepository khoaHocRepository;
  @Autowired
  private LessonRepository lessonRepository;

  // --- THÊM DÒNG NÀY ---
  @Autowired
  private GiaoVienRepository giaoVienRepository; // <-- Cần để gán giáo viên

  // --- CRUD cơ bản ---
  public List<KhoaHoc> findAll() {
    return khoaHocRepository.findAll();
  }

  public KhoaHoc findById(Long id) {
    return khoaHocRepository.findById(id).orElse(null);
  }

  public void deleteById(Long id) {
    khoaHocRepository.deleteById(id);
  }

  // --- SỬA/THAY THẾ HÀM SAVE CŨ BẰNG HÀM NÀY ---
  /**
   * Hàm save này nhận 2 tham số:
   * 1. Đối tượng KhoaHoc (từ form)
   * 2. ID của GiaoVien (từ form)
   */
  public KhoaHoc save(KhoaHoc khoaHoc, Long giaoVienId) {
    // Gán giáo viên cho khóa học trước khi lưu
    GiaoVien giaoVien = giaoVienRepository.findById(giaoVienId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy giáo viên"));
    khoaHoc.setGiaoVien(giaoVien);
    return khoaHocRepository.save(khoaHoc);
  }
  // ------------------------------------

  /**
   * Logic nghiệp vụ "addBaihoc" (từ file KhoaHoc.java cũ)
   */
  public Lesson addLessonToCourse(Long khoaHocId, String title, String noiDung, int thoiLuong) {
    KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

    Lesson newLesson = new Lesson();
    newLesson.setTitle(title);
    newLesson.setNoiDung(noiDung);
    newLesson.setThoiLuong(thoiLuong);
    newLesson.setKhoaHoc(khoaHoc);

    return lessonRepository.save(newLesson);
  }
}