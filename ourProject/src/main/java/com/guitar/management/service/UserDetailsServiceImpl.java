// "dạy" Spring Security cách tìm User trong database của bạn để xử lý Đăng nhập

package com.guitar.management.service;

import com.guitar.management.model.User;
import com.guitar.management.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    // constructor injection (không cần @Autowired)
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Đây là hàm Spring Security sẽ tự gọi khi ai đó cố gắng login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clean = username == null ? "" : username.trim();
        // 1. Tìm User trong DB
        User user = userRepository.findByUsername(clean)
            .orElseThrow(() -> new UsernameNotFoundException("Không tìm thấy user: " + clean));

        String roleName = "HOCVIEN";
        try {
            // 2. Cấp "quyền" (Role) cho user đó
            // (ROLE_GIAOVIEN hoặc ROLE_HOCVIEN)
            if (user.getRole() != null) roleName = user.getRole().name();
        } catch (Exception ignored) {}

        Collection<GrantedAuthority> authorities =
            Collections.singleton(new SimpleGrantedAuthority("ROLE_" + roleName));

        // 3. Trả về cho Spring Security
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(), // Mật khẩu đã mã hóa
            authorities
        );
    }
}
