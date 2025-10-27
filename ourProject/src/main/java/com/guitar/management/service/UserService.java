package com.guitar.management.service;

import com.guitar.management.model.*;
import com.guitar.management.repository.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final GiaoVienRepository giaoVienRepository;
    private final HocVienRepository hocVienRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       GiaoVienRepository giaoVienRepository,
                       HocVienRepository hocVienRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.giaoVienRepository = giaoVienRepository;
        this.hocVienRepository = hocVienRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    public GiaoVien registerNewGiaoVien(String username, String rawPassword, String ten, int tuoi, String chuyenMon) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists: " + username);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(Role.GIAOVIEN);

        GiaoVien gv = new GiaoVien();
        gv.setTen(ten);
        gv.setTuoi(tuoi);
        gv.setChuyenMon(chuyenMon);
        gv.setUser(user);

        return giaoVienRepository.save(gv);
    }

    @Transactional
    public HocVien registerNewHocVien(String username, String rawPassword, String ten, String email, String sdt) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists: " + username);
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(Role.HOCVIEN);

        HocVien hv = new HocVien();
        hv.setTen(ten);
        hv.setEmail(email);
        hv.setSoDienThoai(sdt);
        hv.setLevel(1);
        hv.setUser(user);

        return hocVienRepository.save(hv);
    }
}