package com.guitar.management.config;


import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Set;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        // Bean này là giải pháp cốt lõi:
        // Nó sẽ kiểm tra Role sau khi login thành công và redirect
        @Bean
        public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
                return new AuthenticationSuccessHandler() {
                        @Override
                        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

                                // Lấy danh sách các quyền (roles) của người dùng
                                Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

                                // Logic redirect dựa trên role
                                if (roles.contains("ROLE_GIAOVIEN")) {
                                        response.sendRedirect("/giaovien/home");
                                } else if (roles.contains("ROLE_HOCVIEN")) {
                                        response.sendRedirect("/hocvien/home");
                                } else {
                                        // Nếu không có role cụ thể, về trang chủ
                                        response.sendRedirect("/");
                                }
                        }
                };
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers(
                                                                "/", "/login", "/dangnhap", "/register", "/register/**",
                                                                "/error", "/css/**", "/js/**", "/images/**", "/khoahoc",
                                                                "/giaovien" // Trang danh sách giáo viên vẫn công khai
                                                )
                                                .permitAll()
                                                // Bảo vệ các trang con của giáo viên
                                                .requestMatchers("/giaovien/**").hasRole("GIAOVIEN")
                                                // Bảo vệ các trang con của học viên
                                                .requestMatchers("/hocvien/**").hasRole("HOCVIEN")
                                                // Bất kỳ request nào khác đều cần xác thực
                                                .anyRequest().authenticated())
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .loginProcessingUrl("/login")
                                                // SỬ DỤNG HANDLER MỚI (Giải pháp)
                                                .successHandler(customAuthenticationSuccessHandler())
                                                // KHÔNG SỬ DỤNG .defaultSuccessUrl() NỮA
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout")
                                                .permitAll())
                                .csrf(csrf -> csrf.disable()); // dev only: enable in prod

                return http.build();
        }
}