// File: src/main/java/com/guitar/management/model/GiaoVien.java
package com.guitar.management.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "giao_vien")
public class GiaoVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ten;
    private int tuoi;
    private String chuyenMon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy = "giaoVien")
    private List<KhoaHoc> dsKhoaHoc = new ArrayList<>();

    public GiaoVien() {
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

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<KhoaHoc> getDsKhoaHoc() {
        return dsKhoaHoc;
    }

    public void setDsKhoaHoc(List<KhoaHoc> dsKhoaHoc) {
        this.dsKhoaHoc = dsKhoaHoc;
    }
}