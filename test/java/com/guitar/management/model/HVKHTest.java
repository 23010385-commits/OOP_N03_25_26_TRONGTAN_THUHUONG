package com.guitar.management.model;
import com.guitar.management.model.GiaoVien;
import com.guitar.management.model.Lesson;

public class HVKHTest {
    public static void main(String[] args) {
        // Tao giao vien
        GiaoVien gv = new GiaoVien(1, "Nguyen Van A", 35, "Fingerstyle");

        // Tao bai hoc
        Lesson l1 = new Lesson(1, "Hop am co ban", "Hoc cac hop am C, D, G", 45);

        // In thong tin giao vien
        System.out.println("Thong tin giao vien:");
        gv.showInfo();

        // In thong tin bai hoc
        System.out.println("Thong tin bai hoc:");
        l1.showInfo();

        // Test các phương thức của Lesson
        l1.Batdau();
        l1.Luyentap();
        l1.Hoanthanh();
    }
}
