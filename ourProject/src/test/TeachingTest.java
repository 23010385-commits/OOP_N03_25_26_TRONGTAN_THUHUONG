package test;
import models.GiaoVien;
import models.Lesson;

public class TeachingTest {
    public static void main(String[] args) {
        // Tao giao vien
        GiaoVien gv = new GiaoVien(1, "Nguyen Van A", 0, "Fingerstyle");

        // Tao bai hoc
        Lesson l1 = new Lesson(1, "Hop am co ban", "Hoc cac hop am C, D, G", 45);

        // In thong tin giao vien
        System.out.println("Thong tin giao vien:");
        System.out.println(gv);
        System.out.println("Thong tin bai hoc:");
        System.out.println(l1);
    }
}
