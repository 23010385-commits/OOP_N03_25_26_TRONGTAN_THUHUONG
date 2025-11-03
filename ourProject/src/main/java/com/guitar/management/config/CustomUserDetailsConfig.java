/*
 * Disabled configuration: this file used to publish a second UserDetailsService
 * bean
 * (method annotated with @Bean). The project already contains
 * `UserDetailsServiceImpl` annotated with @Service and @Primary. Publishing two
 * UserDetailsService beans causes Spring Security to ignore a
 * UserDetailsService
 * for the global AuthenticationManager and produces the warning:
 * 
 * "Found 2 UserDetailsService beans... Global Authentication Manager will not use a UserDetailsService"
 * 
 * To avoid that conflict we keep this file for reference but leave it commented
 * out (no @Configuration/@Bean). If you later want to re-enable it, remove the
 * comments and ensure only one UserDetailsService is published or mark one as
 * 
 * @Primary.
 * 
 * Original implementation (kept for reference):
 * 
 * package com.guitar.management.config;
 * 
 * import com.guitar.management.repository.UserRepository;
 * import org.springframework.context.annotation.Bean;
 * import org.springframework.context.annotation.Configuration;
 * import org.springframework.security.core.userdetails.*;
 * import org.springframework.security.core.authority.SimpleGrantedAuthority;
 * 
 * @Configuration
 * public class CustomUserDetailsConfig {
 * 
 * @Bean
 * public UserDetailsService userDetailsService(UserRepository userRepository) {
 * return username -> userRepository.findByUsername(username.trim())
 * .map(u -> {
 * var authorities = java.util.List.of(new SimpleGrantedAuthority("ROLE_" +
 * u.getRole().name()));
 * return new
 * org.springframework.security.core.userdetails.User(u.getUsername(),
 * u.getPassword(),
 * authorities);
 * })
 * .orElseThrow(() -> new UsernameNotFoundException("User not found: " +
 * username));
 * }
 * }
 * 
 */

// File intentionally left without active bean definitions to avoid duplicate
// UserDetailsService beans in the application context.
