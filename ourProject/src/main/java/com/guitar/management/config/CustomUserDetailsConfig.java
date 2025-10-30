package com.guitar.management.config;

import com.guitar.management.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class CustomUserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return username -> userRepository.findByUsername(username.trim())
            .map(u -> {
                var authorities = java.util.List.of(new SimpleGrantedAuthority("ROLE_" + u.getRole().name()));
                return new org.springframework.security.core.userdetails.User(u.getUsername(), u.getPassword(), authorities);
            })
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}