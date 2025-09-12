package models;

import java.util.ArrayList;

public class HocVien {
    // Thuộc tính
    private String ten;                    
    private int tuoi;                         
    private ArrayList<Lesson> learnedLessons; 

    // Hàm tạo
    public HocVien(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.learnedLessons = new ArrayList<>(); // khởi tạo rỗng
    }

    // getter và setter
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

    // Đăng ký học 1 bài học
    public void enrollLesson(Lesson lesson) {
        learnedLessons.add(lesson);
        System.out.println(ten + " da dang ki bai hoc: " + lesson.getTitle());
    }

    // Hiển thị tiến độ học
    public void showProgress() {
        System.out.println("Tien do hoc tap cua " + ten + ":");
        if (learnedLessons.isEmpty()) {
            System.out.println("Chua hoc bai nao.");
        } else {
            for (Lesson l : learnedLessons) {
                System.out.println(l.toString());
            }
        }
    }
}