// File: src/main/java/com/guitar/management/repository/HocVienRepository.java
package com.guitar.management.repository;

import com.guitar.management.model.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // <-- Báo cho Spring: "Đây là một 'Bean'!"
public interface HocVienRepository extends JpaRepository<HocVien, Long> {
    // Tìm HocVien theo user id (dùng khi cần lấy hồ sơ học viên từ username)
    java.util.Optional<HocVien> findByUserId(Long userId);
}