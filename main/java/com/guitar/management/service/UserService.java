// File: src/main/java/com/guitar/management/service/UserService.java
package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <-- Bổ sung @Transactional

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private GiaoVienRepository giaoVienRepository;
  @Autowired
  private HocVienRepository hocVienRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  /**
   * @Transactional
   *                Đảm bảo rằng hoặc TẤT CẢ (tạo User và GiaoVien) cùng thành
   *                công,
   *                hoặc TẤT CẢ cùng thất bại.
   */
  @Transactional
  public GiaoVien registerNewGiaoVien(String username, String password, String ten, int tuoi, String chuyenMon) {

    // --- 1. Xác thực đầu vào ---
    validateInput(username, password);

    // --- 2. Xử lý lỗi (Kiểm tra tồn tại) ---
    if (userRepository.existsByUsername(username)) {
      throw new IllegalArgumentException("Username đã tồn tại: " + username);
    }

    // 3. Tạo và mã hóa tài khoản
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(passwordEncoder.encode(password));
    newUser.setRole(Role.GIAOVIEN); // Gán Role GIAOVIEN

    // 4. Tạo hồ sơ giáo viên
    GiaoVien newGiaoVien = new GiaoVien();
    newGiaoVien.setTen(ten);
    newGiaoVien.setTuoi(tuoi);
    newGiaoVien.setChuyenMon(chuyenMon);

    // 5. Liên kết chúng lại
    newGiaoVien.setUser(newUser);

    // 6. Lưu và trả về
    return giaoVienRepository.save(newGiaoVien);
  }

  /**
   * Đăng ký HỌC VIÊN mới
   */
  @Transactional
  public HocVien registerNewHocVien(String username, String password, String ten, String email, String sdt) {

    // --- 1. Xác thực đầu vào ---
    validateInput(username, password);

    // --- 2. Xử lý lỗi (Kiểm tra tồn tại) ---
    if (userRepository.existsByUsername(username)) {
      throw new IllegalArgumentException("Username đã tồn tại: " + username);
    }

    // 3. Tạo và mã hóa tài khoản
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(passwordEncoder.encode(password));
    newUser.setRole(Role.HOCVIEN); // Gán Role HOCVIEN

    // 4. Tạo hồ sơ học viên
    HocVien newHocVien = new HocVien();
    newHocVien.setTen(ten);
    newHocVien.setEmail(email);
    newHocVien.setSoDienThoai(sdt);
    newHocVien.setLevel(1);

    // 5. Liên kết chúng lại
    newHocVien.setUser(newUser);

    // 6. Lưu và trả về
    return hocVienRepository.save(newHocVien);
  }

  /**
   * Hàm private dùng nội bộ để kiểm tra đầu vào
   */
  private void validateInput(String username, String password) {
    if (username == null || username.trim().isEmpty()) {
      throw new IllegalArgumentException("Username không được để trống");
    }
    if (password == null || password.length() < 6) {
      throw new IllegalArgumentException("Password phải có ít nhất 6 ký tự");
    }
  }
}