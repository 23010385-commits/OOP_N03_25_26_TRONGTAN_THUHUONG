package com.guitar.management.config;

import com.guitar.management.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            userService.registerNewGiaoVien(
                    "teacher1",
                    "password123",
                    "Giao Vien Admin",
                    30,
                    "Quan tri he thong");
            System.out.println(">>> DA TAO TAI KHOAN: teacher1");
        } catch (IllegalArgumentException e) {
            System.out.println(">>> TAI KHOAN teacher1 da ton tai, khong tao moi.");
        }

        try {
            userService.registerNewGiaoVien(
                    "teacher2",
                    "password123",
                    "Giao Vien Guitar",
                    28,
                    "Guitar Co dien");
            System.out.println(">>> DA TAO TAI KHOAN: teacher2");
        } catch (IllegalArgumentException e) {
            System.out.println(">>> TAI KHOAN teacher2 da ton tai, khong tao moi.");
        }
    }
}
