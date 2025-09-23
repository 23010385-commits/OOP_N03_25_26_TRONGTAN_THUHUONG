package test;
import models.GiaoVien;

public class GiaoVienTest {
    public static void main(String[] args) {
        // Tạo giáo viên với đủ thông tin
        GiaoVien gv = new GiaoVien(101, "Nguyen Van A", 35, "Toan");

        System.out.println("=== Test GiaoVien ===");
        gv.showInfo();

        // test setter
        gv.setTen("Tran Thi B");
        gv.setTuoi(40);
        gv.setChuyenMon("Van");

        System.out.println("--- Sau khi thay doi ---");
        gv.showInfo();
    }
}
