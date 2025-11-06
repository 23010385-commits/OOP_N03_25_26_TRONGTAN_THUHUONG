// File: src/main/java/com/guitar/management/model/KhoaHoc.java
package com.guitar.management.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "khoa_hoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenKhoaHoc;
    private String moTa;

    @ManyToOne
    @JoinColumn(name = "giao_vien_id")
    private GiaoVien giaoVien;

    @OneToMany(mappedBy = "khoaHoc", cascade = CascadeType.ALL)
    private List<Lesson> lessons = new ArrayList<>();

    @OneToMany(mappedBy = "khoaHoc")
    private Set<HocVienKhoaHoc> dsHocVien = new HashSet<>();

    public KhoaHoc() {
    } // Hàm tạo rỗng

    // --- Getters & Setters (Xóa hết logic) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenKhoaHoc() {
        return tenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public GiaoVien getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(GiaoVien giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<HocVienKhoaHoc> getDsHocVien() {
        return dsHocVien;
    }

    public void setDsHocVien(Set<HocVienKhoaHoc> dsHocVien) {
        this.dsHocVien = dsHocVien;
    }
}