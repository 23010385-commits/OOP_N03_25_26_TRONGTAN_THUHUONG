// File: src/main/java/com/guitar/management/service/HocVienService.java
package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class HocVienService {

  @Autowired
  private HocVienRepository hocVienRepository;
  @Autowired
  private KhoaHocRepository khoaHocRepository;
  @Autowired
  private HocVienKhoaHocRepository hocVienKhoaHocRepository;

  // --- CRUD cơ bản ---
  public List<HocVien> findAll() {
    return hocVienRepository.findAll();
  }

  public HocVien findById(Long id) {
    return hocVienRepository.findById(id).orElse(null);
  }

  public HocVien save(HocVien hocVien) {
    return hocVienRepository.save(hocVien);
  }

  public void deleteById(Long id) {
    hocVienRepository.deleteById(id);
  }

  // --- LOGIC CŨ (từ HocVien.java) ĐƯỢC CHUYỂN VÀO ĐÂY ---

  /**
   * Logic nghiệp vụ "dangKyKhoaHoc"
   */
  public String dangKyKhoaHoc(Long hocVienId, Long khoaHocId) {
    HocVien hocVien = hocVienRepository.findById(hocVienId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy học viên"));

    KhoaHoc khoaHoc = khoaHocRepository.findById(khoaHocId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy khóa học"));

    // Kiểm tra xem đã đăng ký chưa
    boolean daDangKy = hocVien.getDsDangKy().stream()
        .anyMatch(d -> d.getKhoaHoc().getId().equals(khoaHocId));

    if (daDangKy) {
      return hocVien.getTen() + " đã đăng ký khóa học này rồi!";
    }

    // Tạo một lượt đăng ký mới (bảng trung gian)
    HocVienKhoaHoc dangKyMoi = new HocVienKhoaHoc();
    dangKyMoi.setHocVien(hocVien);
    dangKyMoi.setKhoaHoc(khoaHoc);
    dangKyMoi.setNgayDangKy(new Date());
    dangKyMoi.setTrangThai("Đang học");

    hocVienKhoaHocRepository.save(dangKyMoi);

    return hocVien.getTen() + " đã đăng ký khóa học: " + khoaHoc.getTenKhoaHoc();
  }

  /**
   * Logic nghiệp vụ "levelup"
   */
  public void levelUp(Long hocVienId) {
    HocVien hocVien = hocVienRepository.findById(hocVienId)
        .orElseThrow(() -> new RuntimeException("Không tìm thấy học viên"));

    hocVien.setLevel(hocVien.getLevel() + 1);
    hocVienRepository.save(hocVien);
  }
}