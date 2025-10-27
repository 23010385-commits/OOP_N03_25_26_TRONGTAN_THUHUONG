// File: src/main/java/com/guitar/management/repository/HocVienKhoaHocRepository.java
package com.guitar.management.repository;

import com.guitar.management.model.HocVienKhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // <-- Báo cho Spring: "Đây là một 'Bean'!"
public interface HocVienKhoaHocRepository extends JpaRepository<HocVienKhoaHoc, Long> {
    // Thêm phương thức để kiểm tra xem một học viên đã đăng ký khóa học chưa
    boolean existsByHocVienIdAndKhoaHocId(Long hocVienId, Long khoaHocId);
}