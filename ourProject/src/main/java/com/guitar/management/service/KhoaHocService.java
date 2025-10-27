package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class KhoaHocService {

  private final KhoaHocRepository khoaHocRepository;
  private final LessonRepository lessonRepository;
  private final GiaoVienRepository giaoVienRepository;

  public KhoaHocService(KhoaHocRepository khoaHocRepository,
      LessonRepository lessonRepository,
      GiaoVienRepository giaoVienRepository) {
    this.khoaHocRepository = khoaHocRepository;
    this.lessonRepository = lessonRepository;
    this.giaoVienRepository = giaoVienRepository;
  }

  // --- CRUD cơ bản ---
  public List<KhoaHoc> findAll() {
    return khoaHocRepository.findAll();
  }

  public KhoaHoc findById(Long id) {
    return khoaHocRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học với id: " + id));
  }

  // Hàm save cơ bản (khi không thay đổi giáo viên)
  @Transactional
  public KhoaHoc save(KhoaHoc khoaHoc) {
    if (khoaHoc == null) {
      throw new IllegalArgumentException("KhoaHoc không được null");
    }
    return khoaHocRepository.save(khoaHoc);
  }

  // Hàm save khi gán giáo viên (dùng khi form gửi giaoVienId)
  @Transactional
  public KhoaHoc save(KhoaHoc khoaHoc, Long giaoVienId) {
    if (khoaHoc == null) {
      throw new IllegalArgumentException("KhoaHoc không được null");
    }
    if (giaoVienId != null) {
      GiaoVien giaoVien = giaoVienRepository.findById(giaoVienId)
          .orElseThrow(() -> new RuntimeException("Không tìm thấy giáo viên với id: " + giaoVienId));
      khoaHoc.setGiaoVien(giaoVien);
    } else {
      khoaHoc.setGiaoVien(null);
    }
    return khoaHocRepository.save(khoaHoc);
  }

  public void deleteById(Long id) {
    if (!khoaHocRepository.existsById(id)) {
      throw new RuntimeException("Không tìm thấy khóa học với ID: " + id);
    }
    khoaHocRepository.deleteById(id);
  }

  /**
   * Logic nghiệp vụ "addLessonToCourse"
   * Kiểm tra duplicate dựa trên title trước khi lưu
   */
  @Transactional
  public Lesson addLessonToCourse(Long khoaHocId, String title, String noiDung, int thoiLuong) {
    KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

    boolean tonTai = khoaHoc.getLessons().stream()
        .anyMatch(l -> l.getTitle() != null && l.getTitle().equalsIgnoreCase(title));

    if (tonTai) {
      throw new RuntimeException("Bài học với tiêu đề '" + title + "' đã tồn tại!");
    }

    Lesson newLesson = new Lesson();
    newLesson.setTitle(title);
    newLesson.setNoiDung(noiDung);
    newLesson.setThoiLuong(thoiLuong);
    newLesson.setKhoaHoc(khoaHoc);

    return lessonRepository.save(newLesson);
  }
}