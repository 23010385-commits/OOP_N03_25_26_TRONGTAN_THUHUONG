// File: src/main/java/com/guitar/management/model/HocVien.java
package com.guitar.management.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hoc_vien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ten;
    @Column(unique = true)
    private String email;
    private String soDienThoai;
    private int level;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "hocVien")
    private Set<HocVienKhoaHoc> dsDangKy = new HashSet<>();

    public HocVien() {
    } // Hàm tạo rỗng

    // --- Getters & Setters (Xóa hết logic) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<HocVienKhoaHoc> getDsDangKy() {
        return dsDangKy;
    }

    public void setDsDangKy(Set<HocVienKhoaHoc> dsDangKy) {
        this.dsDangKy = dsDangKy;
    }
}