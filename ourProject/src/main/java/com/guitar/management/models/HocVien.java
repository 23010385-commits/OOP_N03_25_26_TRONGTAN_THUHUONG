package models;

import java.util.ArrayList;
import java.util.List;

public class HocVien {

    // thuoc tinh
    private int id;
    private String ten;
    private String email;
    private String soDienThoai;
    private int level;

    // danh sach khoa hoc da dang ky
    private List<KhoaHoc> dsKhoaHoc;

    // ham tao
    public HocVien(int id, String ten, String email, String soDienThoai) {
        this.id = id;
        this.ten = ten;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.dsKhoaHoc = new ArrayList<>();
        this.level = 1; // Mặc định cấp độ bắt đầu là 1
    }

    // getter va setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<KhoaHoc> getDsKhoaHoc() {
        return dsKhoaHoc;
    }

    // phuong thuc dang ky khoa hoc
    public void dangKyKhoaHoc(KhoaHoc khoaHoc) {
        if (!dsKhoaHoc.contains(khoaHoc)) {
            dsKhoaHoc.add(khoaHoc);
            System.out.println(ten + " da dang ky khoa hoc: " + khoaHoc.getTenKhoaHoc());
        } else {
            System.out.println(ten + " da dang ky khoa hoc nay roi!");
        }
    }

    // phuong thuc hien thi danh sach khoa hoc
    public void showKhoaHocDaDangKy() {
        System.out.println("------ Hoc vien " + ten + " ------");
        if (dsKhoaHoc.isEmpty()) {
            System.out.println("Chua dang ky khoa hoc nao");
        } else {
            for (KhoaHoc kh : dsKhoaHoc) {
                System.out.println("- " + kh.getTenKhoaHoc());
            }
        }
        System.out.println("-------------------------------\n");
    }

    // phuong thuc in thong tin hoc vien
    public void showInfo() {
        System.out.println("------ Hoc vien ------");
        System.out.println("ID    : " + id);
        System.out.println("Ten   : " + ten);
        System.out.println("Email : " + email);
        System.out.println("SDT   : " + soDienThoai);
        System.out.println("Level : " + level);
        System.out.println("----------------------\n");
    }

    public void thuchanh() {
        System.out.println("Hoc vien dang thuc hanh.");
    }

    public void levelup() {
        level++;
        System.out.println("Hoc vien da len cap: " + level);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }   
}
