// File: src/main/java/com/guitar/management/config/SecurityConfig.java
package com.guitar.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Cấu hình bảo mật cho ứng dụng
@Configuration
public class SecurityConfig {

  /**
   * Tạo một hạt đậu (Bean) PasswordEncoder để cả hệ thống
   * có thể @Autowired và sử dụng chung một cơ chế mã hóa.
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}