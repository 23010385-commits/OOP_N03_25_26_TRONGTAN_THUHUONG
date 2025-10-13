package ourProject.src.main.java.com.guitar.management.model;

import java.util.ArrayList;
import java.util.List;

public class KhoaHoc {

    // thuoc tinh
    private int id;
    private String tenKhoaHoc;
    private String moTa;
    private GiaoVien giaoVien;
    private List<Lesson> lessons;   

    // ham tao
    public KhoaHoc(int id, String tenKhoaHoc, String moTa, GiaoVien giaoVien) {
        this.id = id;
        this.tenKhoaHoc = tenKhoaHoc;
        this.moTa = moTa;
        this.giaoVien = giaoVien;
        this.lessons = new ArrayList<>();
    }

    // getter va setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void addBaihoc(Lesson baihoc) {
        for (Lesson b : lessons) {
            if (b.getLessonID() == baihoc.getLessonID()) {
                System.out.println("Bai hoc da ton tai.");
                return;
            }
        }
        lessons.add(baihoc);
    }

    public void removeBaihoc(int id) {
        lessons.removeIf(b -> b.getLessonID() == id);
    }

    public void updateBaihoc(int id, String newTen) {
        for (Lesson b : lessons) {
            if (b.getLessonID() == id) {
                b.setTitle(newTen);
                break;
            }
        }
    }

    // phuong thuc hien thi noi dung khoa hoc
    public void showNoiDungKhoaHoc() {
        System.out.println("------ Khoa hoc: " + tenKhoaHoc + " ------");
        System.out.println("Mo ta     : " + moTa);
        System.out.println("Giao vien : " + (giaoVien != null ? giaoVien.getTen() : "Chua co"));
        if (lessons.isEmpty()) {
            System.out.println("Chua co bai hoc nao trong khoa hoc");
        } else {
            System.out.println("Danh sach bai hoc:");
            for (Lesson l : lessons) {
                System.out.println("- " + l.getTitle() + " (" + l.getThoiLuong() + " phut)");
            }
        }
        System.out.println("----------------------------------------\n");
    }
}
