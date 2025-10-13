package ourProject.test.java.com.guitar.management.model;
import ourProject.src.main.java.com.guitar.management.model.GiaoVien;
import ourProject.src.main.java.com.guitar.management.model.KhoaHoc;

public class GiaoVienTest {
    public static void main(String[] args) {
        // Tạo giáo viên với đủ thông tin
        GiaoVien gv = new GiaoVien(101, "Nguyen Van A", 35, "Thanh Nhac");

        System.out.println("=== Test GiaoVien ===");
        gv.showInfo();

        // Test setter
        gv.setTen("Tran Thi B");
        gv.setTuoi(40);
        gv.setChuyenMon("Nhac Co Dien");

        System.out.println("--- Sau khi thay doi ---");
        gv.showInfo();

        // Test thêm khóa học
        KhoaHoc kh1 = new KhoaHoc(1, "Guitar Basics", "Learn the basics of guitar", gv);
        KhoaHoc kh2 = new KhoaHoc(2, "Advanced Guitar", "Master advanced techniques", gv);

        gv.themKhoaHoc(kh1);
        gv.themKhoaHoc(kh2);

        System.out.println("--- Danh sach khoa hoc phu trach ---");
        gv.showKhoaHocPhuTrach();

        // Test trường hợp đặc biệt
        GiaoVien gv2 = new GiaoVien(102, "", -5, "");
        System.out.println("--- Test GiaoVien voi thong tin khong hop le ---");
        gv2.showInfo();
    }
}
