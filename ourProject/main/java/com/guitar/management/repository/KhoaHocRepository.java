// File: src/main/java/com/guitar/management/repository/KhoaHocRepository.java
package com.guitar.management.repository;

import com.guitar.management.model.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // <-- Báo cho Spring: "Đây là một 'Bean'!"
public interface KhoaHocRepository extends JpaRepository<KhoaHoc, Long> {
    // Tìm khóa học theo từ khoá trong tiêu đề hoặc mô tả (dùng cho filter Cơ bản /
    // Nâng cao)
    java.util.List<KhoaHoc> findByTenKhoaHocContainingIgnoreCaseOrMoTaContainingIgnoreCase(String ten, String moTa);
}