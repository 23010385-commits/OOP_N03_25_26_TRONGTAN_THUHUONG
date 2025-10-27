package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class HocVienService {

  private final HocVienRepository hocVienRepository;
  private final KhoaHocRepository khoaHocRepository;
  private final HocVienKhoaHocRepository hocVienKhoaHocRepository;

  // ✅ Constructor injection — chuẩn, dễ test, không cần @Autowired
  public HocVienService(HocVienRepository hocVienRepository,
      KhoaHocRepository khoaHocRepository,
      HocVienKhoaHocRepository hocVienKhoaHocRepository) {
    this.hocVienRepository = hocVienRepository;
    this.khoaHocRepository = khoaHocRepository;
    this.hocVienKhoaHocRepository = hocVienKhoaHocRepository;
  }

  // ===== CRUD CƠ BẢN =====
  public List<HocVien> findAll() {
    return hocVienRepository.findAll();
  }

  public HocVien findById(Long id) {
    return hocVienRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("❌ Không tìm thấy học viên với ID: " + id));
  }

  public HocVien save(HocVien hocVien) {
    if (hocVien == null) {
      throw new IllegalArgumentException("❌ Học viên không được null");
    }
    if (hocVien.getTen() == null || hocVien.getTen().trim().isEmpty()) {
      throw new IllegalArgumentException("⚠️ Tên học viên không được để trống");
    }
    if (hocVien.getEmail() == null || hocVien.getEmail().trim().isEmpty()) {
      throw new IllegalArgumentException("⚠️ Email không được để trống");
    }

    // Nếu muốn kiểm tra trùng email:
    // if (hocVienRepository.existsByEmail(hocVien.getEmail())) {
    // throw new RuntimeException("Email đã tồn tại trong hệ thống!");
    // }

    return hocVienRepository.save(hocVien);
  }

  public void deleteById(Long id) {
    if (!hocVienRepository.existsById(id)) {
      throw new RuntimeException("❌ Không thể xóa: Không tìm thấy học viên ID: " + id);
    }
    hocVienRepository.deleteById(id);
  }

  // ===== NGHIỆP VỤ ĐẶC THÙ =====

  /**
   * Đăng ký khóa học cho học viên
   * - Có kiểm tra trùng
   * - Có transaction để rollback nếu lỗi
   */
  @Transactional
  public String dangKyKhoaHoc(Long hocVienId, Long khoaHocId) {
    if (hocVienId == null || khoaHocId == null) {
      throw new IllegalArgumentException("⚠️ HocVienId và KhoaHocId không được null");
    }

    HocVien hocVien = hocVienRepository.findById(hocVienId)
        .orElseThrow(() -> new RuntimeException("❌ Không tìm thấy học viên ID: " + hocVienId));

    KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocId)
        .orElseThrow(() -> new RuntimeException("❌ Không tìm thấy khóa học ID: " + khoaHocId));

    boolean daDangKy = hocVienKhoaHocRepository.existsByHocVienIdAndKhoaHocId(hocVienId, khoaHocId);
    if (daDangKy) {
      return "⚠️ " + hocVien.getTen() + " đã đăng ký khóa học này rồi!";
    }

    HocVienKhoaHoc dangKyMoi = new HocVienKhoaHoc();
    dangKyMoi.setHocVien(hocVien);
    dangKyMoi.setKhoaHoc(khoaHoc);
    dangKyMoi.setNgayDangKy(new Date());
    dangKyMoi.setTrangThai("Đang học");

    hocVienKhoaHocRepository.save(dangKyMoi);
    return "✅ " + hocVien.getTen() + " đã đăng ký khóa học: " + khoaHoc.getTenKhoaHoc();
  }

  /**
   * Tăng level cho học viên
   */
  @Transactional
  public void levelUp(Long hocVienId) {
    HocVien hocVien = hocVienRepository.findById(hocVienId)
        .orElseThrow(() -> new RuntimeException("❌ Không tìm thấy học viên ID: " + hocVienId));

    hocVien.setLevel(hocVien.getLevel() + 1);
    hocVienRepository.save(hocVien);
  }
}
