package test;
import models.HocVien;

public class HocVienTest {
    public static void main(String[] args) {
        // Tao hoc vien moi
        HocVien hv1 = new HocVien(1, "Nguyen Van A", "a@gmail.com", "0123456789");

        // In ra thong tin hoc vien
        System.out.println(hv1);

    }
}
