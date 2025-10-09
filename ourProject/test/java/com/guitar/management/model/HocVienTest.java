package test;
import models.HocVien;

public class HocVienTest {
    public static void main(String[] args) {
        // Tao hoc vien moi
        HocVien hv1 = new HocVien(1, "Nguyen Van A", "a@gmail.com", "0123456789");

        // In ra thong tin hoc vien
        System.out.println(hv1);

        // Test levelup method
        hv1.levelup();
        System.out.println("Level sau khi levelup: " + hv1.getLevel());

        // Test thuchanh method
        hv1.thuchanh();

        // Test dangKyKhoaHoc method
        models.KhoaHoc khoaHoc = new models.KhoaHoc(1, "Guitar Basics", "Learn the basics of guitar", null);
        hv1.dangKyKhoaHoc(khoaHoc);
        System.out.println("Danh sach khoa hoc da dang ky: " + hv1.getDsKhoaHoc());
    }
}
