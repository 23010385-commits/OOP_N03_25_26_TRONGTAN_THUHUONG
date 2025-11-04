package com.guitar.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http
                                .authorizeHttpRequests(authz -> authz
                                                .requestMatchers(
                                                                "/", "/login", "/dangnhap", "/register", "/register/**",
                                                                "/error", "/css/**", "/js/**", "/images/**", "/khoahoc",
                                                                "/giaovien")
                                                .permitAll()
                                                .anyRequest().authenticated() // production: authenticated; for dev
                                                                              // change to .permitAll()
                                )
                                .formLogin(form -> form
                                                .loginPage("/login") // form action page
                                                .loginProcessingUrl("/login") // Spring Security processing URL (keep
                                                                              // /login)
                                                .defaultSuccessUrl("/", true)
                                                .permitAll())
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .logoutSuccessUrl("/login?logout")
                                                .permitAll())
                                .csrf(csrf -> csrf.disable()); // dev only: enable in prod

                return http.build();
        }
}