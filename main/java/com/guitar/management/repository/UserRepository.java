// File: src/main/java/com/guitar/management/repository/UserRepository.java
package com.guitar.management.repository;

import com.guitar.management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);

  // --- CẢI TIẾN 5: Thêm hàm kiểm tra tồn tại ---
  /**
   * Tự động tạo câu lệnh kiểm tra xem có username
   * nào trong bảng 'users' hay không.
   */
  boolean existsByUsername(String username);
}