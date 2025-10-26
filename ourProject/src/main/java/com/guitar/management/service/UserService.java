// File: src/main/java/com/guitar/management/service/UserService.java
package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <-- CẢI TIẾN 3

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
   * CẢI TIẾN 3: @Transactional
   * Đảm bảo rằng hoặc TẤT CẢ (tạo User và GiaoVien) cùng thành công,
   * hoặc TẤT CẢ cùng thất bại. Không bao giờ có trường hợp
   * tạo được User mà không tạo được GiaoVien.
   */
  @Transactional
  // CẢI TIẾN 4: Trả về đối tượng đã tạo
  public GiaoVien registerNewGiaoVien(String username, String password, String ten, int tuoi, String chuyenMon) {

    // --- CẢI TIẾN 2: Xác thực đầu vào ---
    validateInput(username, password);

    // --- CẢI TIẾN 1: Xử lý lỗi (Kiểm tra tồn tại) ---
    if (userRepository.existsByUsername(username)) {
      throw new IllegalArgumentException("Username đã tồn tại: " + username);
    }

    // 1. Tạo và mã hóa tài khoản
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(passwordEncoder.encode(password));
    newUser.setRole(Role.GIAOVIEN);

    // 2. Tạo hồ sơ giáo viên
    GiaoVien newGiaoVien = new GiaoVien();
    newGiaoVien.setTen(ten);
    newGiaoVien.setTuoi(tuoi);
    newGiaoVien.setChuyenMon(chuyenMon);

    // 3. Liên kết chúng lại với nhau
    newGiaoVien.setUser(newUser);

    // 4. Lưu và trả về đối tượng (CẢI TIẾN 4)
    return giaoVienRepository.save(newGiaoVien);
  }

  @Transactional
  public HocVien registerNewHocVien(String username, String password, String ten, String email, String sdt) {

    // --- CẢI TIẾN 2: Xác thực đầu vào ---
    validateInput(username, password);

    // --- CẢI TIẾN 1: Xử lý lỗi (Kiểm tra tồn tại) ---
    if (userRepository.existsByUsername(username)) {
      throw new IllegalArgumentException("Username đã tồn tại: " + username);
    }

    // 1. Tạo và mã hóa tài khoản
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(passwordEncoder.encode(password));
    newUser.setRole(Role.HOCVIEN);

    // 2. Tạo hồ sơ học viên
    HocVien newHocVien = new HocVien();
    newHocVien.setTen(ten);
    newHocVien.setEmail(email);
    newHocVien.setSoDienThoai(sdt);
    newHocVien.setLevel(1);

    // 3. Liên kết chúng lại
    newHocVien.setUser(newUser);

    // 4. Lưu và trả về đối tượng (CẢI TIẾN 4)
    return hocVienRepository.save(newHocVien);
  }

  /**
   * Hàm private dùng nội bộ để kiểm tra đầu vào
   * (Áp dụng CẢI TIẾN 2)
   */
  private void validateInput(String username, String password) {
    if (username == null || username.trim().isEmpty()) {
      throw new IllegalArgumentException("Username không được để trống");
    }
    if (password == null || password.length() < 6) {
      throw new IllegalArgumentException("Password phải có ít nhất 6 ký tự");
    }
    // Bạn có thể thêm các kiểm tra khác ở đây (ví dụ: email hợp lệ...)
  }
}