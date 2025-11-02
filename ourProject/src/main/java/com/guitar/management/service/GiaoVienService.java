// File: src/main/java/com/guitar/management/service/GiaoVienService.java
package com.guitar.management.service;

import com.guitar.management.model.GiaoVien;
import com.guitar.management.repository.GiaoVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GiaoVienService {

  @Autowired
  private GiaoVienRepository giaoVienRepository;

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
    giaoVienRepository.deleteById(id);
  }
}