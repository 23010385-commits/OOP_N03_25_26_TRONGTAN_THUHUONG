import models.HocVien;
import models.Lesson;
import models.KhoaHoc;
import models.GiaoVien;

public class App {
    public static void main(String[] args) {
        // Tao giao vien
        GiaoVien gv = new GiaoVien(1, "Tran Van A", 35, "Nhac co dien");
        gv.showInfo();

        // Tao bai hoc
        Lesson l1 = new Lesson(1, "Gioi thieu dan guitar", "Ten cac bo phan cua dan", 30);
        Lesson l2 = new Lesson(2, "Hop am co ban", "Hoc hop am C, D, G", 45);

    // Tao khoa hoc
    KhoaHoc khoaHoc = new KhoaHoc(1, "Khoa hoc Guitar co ban", "Hoc cac kien thuc nen tang", gv);
        khoaHoc.addBaihoc(l1);
        khoaHoc.addBaihoc(l2);

        // Tao hoc vien
        HocVien hv1 = new HocVien(1, "Nguyen Van B", "b@gmail.com", "0123456789");
        HocVien hv2 = new HocVien(2, "Le Thi C", "c@gmail.com", "0987654321");

        // Hoc vien dang ky khoa hoc
        hv1.dangKyKhoaHoc(khoaHoc);
        hv2.dangKyKhoaHoc(khoaHoc);

        // In thong tin khoa hoc
        System.out.println("\n--- Thong tin khoa hoc ---");
        System.out.println(khoaHoc);

        // In danh sach bai hoc
        System.out.println("\n--- Danh sach bai hoc ---");
        for (Lesson l : khoaHoc.getLessons()) {
            l.showInfo();
        }

        // Hoc vien xem khoa hoc da dang ky
        System.out.println("\n--- Khoa hoc da dang ky ---");
        hv1.showKhoaHocDaDangKy();
        hv2.showKhoaHocDaDangKy();
    }
}
