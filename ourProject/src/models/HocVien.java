

import java.util.ArrayList;
import java.util.List;

public class HocVien {
    private int hocVienID;
    private String ten;
    private String email;
    private String soDienThoai;

    // Danh sach cac khoa hoc da dang ky
    private List<KhoaHoc> khoaHocDaDangKy;

    // Ham tao
    public HocVien(int id, String ten, String email, String sdt) {
        this.hocVienID = id;
        this.ten = ten;
        this.email = email;
        this.soDienThoai = sdt;
        this.khoaHocDaDangKy = new ArrayList<>();
    }

    // Phuong thuc dang ky khoa hoc
    public void dangKyKhoaHoc(KhoaHoc khoaHoc) {
        if (!khoaHocDaDangKy.contains(khoaHoc)) {
            khoaHocDaDangKy.add(khoaHoc);
            System.out.println(ten + " da dang ky khoa hoc: " + khoaHoc.getTenKhoaHoc());
        } else {
            System.out.println(ten + " da dang ky khoa hoc nay roi!");
        }
    }

    // Xem danh sach khoa hoc da dang ky
    public void showKhoaHocDaDangKy() {
        System.out.println("Hoc vien " + ten + " da dang ky cac khoa hoc:");
        for (KhoaHoc c : khoaHocDaDangKy) {
            System.out.println("- " + c.getTenKhoaHoc());
        }
    }

    @Override
    public String toString() {
        return "Hoc vien #" + hocVienID + ": " + ten + "\nEmail: " + email + "\nSo dien thoai: " + soDienThoai + "\n";
    }
}
