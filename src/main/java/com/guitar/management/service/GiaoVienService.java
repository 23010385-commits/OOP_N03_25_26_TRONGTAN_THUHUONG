// File: src/main/java/com/guitar/management/service/GiaoVienService.java
package com.guitar.management.service;

import com.guitar.management.model.GiaoVien;
import com.guitar.management.repository.GiaoVienRepository;
import com.guitar.management.repository.KhoaHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GiaoVienService {

  @Autowired
  private GiaoVienRepository giaoVienRepository;
  @Autowired
  private KhoaHocRepository khoaHocRepository;

  // 1. READ (Đọc)
  public List<GiaoVien> findAll() {
    return giaoVienRepository.findAll();
  }

  public GiaoVien findById(Long id) {
    return giaoVienRepository.findById(id).orElse(null);
  }

  // 2. CREATE (Tạo) & 3. UPDATE (Sửa)
  public GiaoVien save(GiaoVien giaoVien) {
    return giaoVienRepository.save(giaoVien);
  }

  // 4. DELETE (Xóa)
  public void deleteById(Long id) {
    // Before deleting a teacher, detach them from any courses to avoid FK
    // constraint
    giaoVienRepository.findById(id).ifPresent(gv -> {
      if (gv.getDsKhoaHoc() != null && !gv.getDsKhoaHoc().isEmpty()) {
        gv.getDsKhoaHoc().forEach(kh -> {
          kh.setGiaoVien(null);
          khoaHocRepository.save(kh);
        });
      }
    });

    giaoVienRepository.deleteById(id);
  }
}