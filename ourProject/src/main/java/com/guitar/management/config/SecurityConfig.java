package com.guitar.management.config;

import com.guitar.management.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  // "Tiêm" dịch vụ tìm user mà bạn vừa tạo
  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  // Bean 1: Máy mã hóa (UserService cần cái này)
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // Bean 2: Bộ lọc bảo vệ (Cấu hình login VÀ phân quyền)
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authz -> authz
            // Cho phép khách xem trang chủ, trang đăng ký, và file CSS/JS
            .requestMatchers("/", "/register/**", "/css/**", "/js/**").permitAll()

            // Yêu cầu phải là GIAOVIEN mới được vào trang /giaovien/**
            .requestMatchers("/giaovien/**").hasRole("GIAOVIEN")

            // Tất cả các request khác (như /khoahoc, /hocvien)
            // đều BẮT BUỘC phải đăng nhập
            .anyRequest().authenticated())
        .formLogin(form -> form
            // Chỉ định trang login của chúng ta là "/login"
            .loginPage("/login")
            // Trang sẽ đến sau khi login thành công
            .defaultSuccessUrl("/", true)
            .permitAll() // Cho phép tất cả mọi người xem trang login
        )
        .logout(logout -> logout
            .logoutSuccessUrl("/") // Trang sẽ đến sau khi logout
            .permitAll())
        // Bảo Spring Security dùng dịch vụ UserDetailsServiceImpl của ta
        .userDetailsService(userDetailsService);

    return http.build();
  }
}