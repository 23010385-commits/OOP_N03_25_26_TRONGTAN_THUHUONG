package com.guitar.management.model;

import java.util.Date;

public class HocVienKhoaHoc {
    private int id;
    private HocVien hocVien;
    private KhoaHoc khoaHoc;
    private Lesson lesson;
    private Date ngayHoc;
    private String trangThai; // vd: "Đang học", "Hoàn thành"

    public HocVienKhoaHoc(int id, HocVien hocVien, KhoaHoc khoaHoc, Lesson lesson, Date ngayHoc, String trangThai) {
        this.id = id;
        this.hocVien = hocVien;
        this.khoaHoc = khoaHoc;
        this.lesson = lesson;
        this.ngayHoc = ngayHoc;
        this.trangThai = trangThai;
    }

    // Getter và Setter
    public int getId() { return id; }
    public HocVien getHocVien() { return hocVien; }
    public KhoaHoc getKhoaHoc() { return khoaHoc; }
    public Lesson getLesson() { return lesson; }
    public Date getNgayHoc() { return ngayHoc; }
    public String getTrangThai() { return trangThai; }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HocVienKhoaHoc{" +
                "id=" + id +
                ", hocVien=" + hocVien.getTen() +
                ", khoaHoc=" + khoaHoc.getTenKhoaHoc() +
                ", lesson=" + lesson.getTitle() +
                ", ngayHoc=" + ngayHoc +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
