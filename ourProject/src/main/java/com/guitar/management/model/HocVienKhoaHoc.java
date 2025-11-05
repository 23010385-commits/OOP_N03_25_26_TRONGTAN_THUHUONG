// File: src/main/java/com/guitar/management/model/HocVienKhoaHoc.java
package com.guitar.management.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hoc_vien_khoa_hoc") // Bảng trung gian
public class HocVienKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hoc_vien_id")
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "khoa_hoc_id")
    private KhoaHoc khoaHoc;

    private Date ngayDangKy;
    private String trangThai; // "Đang học", "Hoàn thành"

    public HocVienKhoaHoc() {
    } // Hàm tạo rỗng

    // --- Getters & Setters (Xóa hết logic) ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HocVien getHocVien() {
        return hocVien;
    }

    public void setHocVien(HocVien hocVien) {
        this.hocVien = hocVien;
    }

    public KhoaHoc getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(KhoaHoc khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}