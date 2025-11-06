// File: src/main/java/com/guitar/management/repository/GiaoVienRepository.java
package com.guitar.management.repository;

import com.guitar.management.model.GiaoVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // <-- THÊM DÒNG NÀY

@Repository // <-- Báo cho Spring: "Đây chính là 'Thủ kho' (Bean)!"
public interface GiaoVienRepository extends JpaRepository<GiaoVien, Long> {
    // Để trống. Spring sẽ tự động cung cấp save(), findAll(), v.v.
}