package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KhoaHocService {

  private final KhoaHocRepository khoaHocRepository;
  private final LessonRepository lessonRepository;
  private final GiaoVienRepository giaoVienRepository;
  private final HocVienRepository hocVienRepository;
  private final HocVienKhoaHocRepository hocVienKhoaHocRepository;
  private final UserRepository userRepository;

  public KhoaHocService(KhoaHocRepository khoaHocRepository,
      LessonRepository lessonRepository,
      GiaoVienRepository giaoVienRepository,
      HocVienRepository hocVienRepository,
      HocVienKhoaHocRepository hocVienKhoaHocRepository,
      UserRepository userRepository) {
    this.khoaHocRepository = khoaHocRepository;
    this.lessonRepository = lessonRepository;
    this.giaoVienRepository = giaoVienRepository;
    this.hocVienRepository = hocVienRepository;
    this.hocVienKhoaHocRepository = hocVienKhoaHocRepository;
    this.userRepository = userRepository;
  }

  // Null-safe helpers (không thay đổi logic hiện tại)
  public Optional<KhoaHoc> findOptionalById(Long id) {
    if (id == null)
      return Optional.empty();
    return khoaHocRepository.findById(id);
  }

  public KhoaHoc findByIdOrNull(Long id) {
    return findOptionalById(id).orElse(null);
  }

  // --- CRUD cơ bản ---
  public List<KhoaHoc> findAll() {
    return khoaHocRepository.findAll();
  }

  /**
   * Lấy danh sách khóa học lọc theo level (basic|advanced) — đơn giản dựa trên từ
   * khoá trong
   * tiêu đề/mô tả: 'sơ cấp' cho basic, 'nâng cao' cho advanced.
   */
  public List<KhoaHoc> findAllByLevel(String level) {
    if (level == null || level.trim().isEmpty())
      return findAll();
    String key = level.trim().toLowerCase();
    String keyword;
    if (key.equals("basic") || key.equals("so-cap") || key.equals("sơ-cấp") || key.equals("sơ cấp")) {
      keyword = "sơ cấp";
    } else if (key.equals("advanced") || key.equals("nang-cao") || key.equals("nâng-cao") || key.equals("nâng cao")) {
      keyword = "nâng cao";
    } else {
      // fallback: use raw level value as keyword
      keyword = level;
    }
    return khoaHocRepository.findByTenKhoaHocContainingIgnoreCaseOrMoTaContainingIgnoreCase(keyword, keyword);
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
   * - Validate input (title, thoiLuong)
   * - Kiểm tra trùng tiêu đề (case-insensitive)
   */
  @Transactional
  public Lesson addLessonToCourse(Long khoaHocId, String title, String noiDung, int thoiLuong) {
    if (title == null || title.trim().isEmpty()) {
      throw new IllegalArgumentException("Tiêu đề bài học không được để trống");
    }
    if (thoiLuong <= 0) {
      throw new IllegalArgumentException("Thời lượng bài học phải lớn hơn 0");
    }

    KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học với id: " + khoaHocId));

    String cleanTitle = title.trim();

    boolean tonTai = khoaHoc.getLessons().stream()
        .anyMatch(l -> l.getTitle() != null && l.getTitle().trim().equalsIgnoreCase(cleanTitle));

    if (tonTai) {
      throw new RuntimeException("Bài học '" + cleanTitle + "' đã tồn tại!");
    }

    Lesson newLesson = new Lesson();
    newLesson.setTitle(cleanTitle);
    newLesson.setNoiDung(noiDung);
    newLesson.setThoiLuong(thoiLuong);
    newLesson.setKhoaHoc(khoaHoc);

    return lessonRepository.save(newLesson);
  }

  /**
   * Enroll the currently authenticated student into the given course.
   * Throws RuntimeException on failure (no authenticated user, not a student,
   * already enrolled, etc.).
   */
  @Transactional
  public void enrollCurrentStudentToCourse(Long khoaHocId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || auth.getName() == null) {
      throw new RuntimeException("Không có người dùng đăng nhập");
    }

    String username = auth.getName();
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản người dùng: " + username));

    HocVien hocVien = hocVienRepository.findByUserId(user.getId())
        .orElseThrow(() -> new RuntimeException("Hồ sơ học viên không tồn tại cho user: " + username));

    KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học với id: " + khoaHocId));

    boolean already = hocVienKhoaHocRepository.existsByHocVienIdAndKhoaHocId(hocVien.getId(), khoaHocId);
    if (already) {
      throw new RuntimeException("Bạn đã đăng ký khóa học này rồi");
    }

    HocVienKhoaHoc hvkh = new HocVienKhoaHoc();
    hvkh.setHocVien(hocVien);
    hvkh.setKhoaHoc(khoaHoc);
    hvkh.setNgayDangKy(new Date());
    hvkh.setTrangThai("Dang hoc");

    hocVienKhoaHocRepository.save(hvkh);
  }

  /**
   * Hủy đăng ký khóa học cho học viên hiện tại
   */
  @Transactional
  public void unenrollCurrentStudentFromCourse(Long khoaHocId) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || auth.getName() == null) {
      throw new RuntimeException("Không có người dùng đăng nhập");
    }

    String username = auth.getName();
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy tài khoản người dùng: " + username));

    HocVien hocVien = hocVienRepository.findByUserId(user.getId())
        .orElseThrow(() -> new RuntimeException("Hồ sơ học viên không tồn tại cho user: " + username));

    boolean exists = hocVienKhoaHocRepository.existsByHocVienIdAndKhoaHocId(hocVien.getId(), khoaHocId);
    if (!exists) {
      throw new RuntimeException("Bạn chưa đăng ký khóa học này");
    }

    // Xóa bản ghi đăng ký
    hocVienKhoaHocRepository.deleteByHocVienIdAndKhoaHocId(hocVien.getId(), khoaHocId);
  }

  /**
   * Lấy tập các courseId mà học viên hiện tại đã đăng ký — dùng để render UI
   */
  public java.util.Set<Long> getEnrolledCourseIdsForCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth == null || auth.getName() == null) {
      return java.util.Collections.emptySet();
    }

    String username = auth.getName();
    java.util.Optional<User> maybeUser = userRepository.findByUsername(username);
    if (maybeUser.isEmpty())
      return java.util.Collections.emptySet();

    User user = maybeUser.get();
    java.util.Optional<HocVien> maybeHv = hocVienRepository.findByUserId(user.getId());
    if (maybeHv.isEmpty())
      return java.util.Collections.emptySet();

    HocVien hv = maybeHv.get();
    java.util.List<HocVienKhoaHoc> list = hocVienKhoaHocRepository.findByHocVienId(hv.getId());
    java.util.Set<Long> ids = new java.util.HashSet<>();
    for (HocVienKhoaHoc r : list) {
      if (r.getKhoaHoc() != null && r.getKhoaHoc().getId() != null)
        ids.add(r.getKhoaHoc().getId());
    }
    return ids;
  }
}