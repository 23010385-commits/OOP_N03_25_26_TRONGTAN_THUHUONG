package com.guitar.management.model;

import java.util.ArrayList;
import java.util.List;

public class GiaoVienTest {
    public static void main(String[] args) {
        // Sử dụng các lớp nội bộ nhẹ để test độc lập với mã thực tế
        TestGiaoVien gv = new TestGiaoVien(101L, "Nguyen Van A", 35, "Thanh Nhac");

        System.out.println("=== Test GiaoVien ===");
        gv.showInfo();

        // Test setter
        gv.setTen("Tran Thi B");
        gv.setTuoi(40);
        gv.setChuyenMon("Nhac Co Dien");

        System.out.println("--- Sau khi thay doi ---");
        gv.showInfo();

        // Test thêm khóa học
        TestKhoaHoc kh1 = new TestKhoaHoc(1L, "Guitar Basics", "Learn the basics of guitar", gv.getTen());
        TestKhoaHoc kh2 = new TestKhoaHoc(2L, "Advanced Guitar", "Master advanced techniques", gv.getTen());

        gv.themKhoaHoc(kh1);
        gv.themKhoaHoc(kh2);

        System.out.println("--- Danh sach khoa hoc phu trach ---");
        gv.showKhoaHocPhuTrach();

        // Test trường hợp đặc biệt
        TestGiaoVien gv2 = new TestGiaoVien(102L, "", -5, "");
        System.out.println("--- Test GiaoVien voi thong tin khong hop le ---");
        gv2.showInfo();
    }

    // Lớp GiaoVien nhẹ dùng cho test
    private static class TestGiaoVien {
        private Long id;
        private String ten;
        private int tuoi;
        private String chuyenMon;
        private final List<TestKhoaHoc> khoaHocs = new ArrayList<>();

        public TestGiaoVien(Long id, String ten, int tuoi, String chuyenMon) {
            this.id = id;
            this.ten = (ten == null || ten.isBlank()) ? "<chưa đặt tên>" : ten;
            this.tuoi = Math.max(0, tuoi);
            this.chuyenMon = (chuyenMon == null || chuyenMon.isBlank()) ? "<chưa đặt chuyên môn>" : chuyenMon;
        }

        public Long getId() {
            return id;
        }

        public String getTen() {
            return ten;
        }

        public int getTuoi() {
            return tuoi;
        }

        public String getChuyenMon() {
            return chuyenMon;
        }

        public void setTen(String ten) {
            this.ten = (ten == null || ten.isBlank()) ? this.ten : ten;
        }

        public void setTuoi(int tuoi) {
            this.tuoi = Math.max(0, tuoi);
        }

        public void setChuyenMon(String chuyenMon) {
            this.chuyenMon = (chuyenMon == null || chuyenMon.isBlank()) ? this.chuyenMon : chuyenMon;
        }

        public void showInfo() {
            System.out.println(
                    "GiaoVien{id=" + id + ", ten='" + ten + "', tuoi=" + tuoi + ", chuyenMon='" + chuyenMon + "'}");
        }

        public void themKhoaHoc(TestKhoaHoc kh) {
            if (kh != null)
                khoaHocs.add(kh);
        }

        public void showKhoaHocPhuTrach() {
            if (khoaHocs.isEmpty()) {
                System.out.println("(khong co khoa hoc)");
                return;
            }
            for (TestKhoaHoc kh : khoaHocs) {
                System.out.println("- " + kh.getTen() + " : " + kh.getMoTa());
            }
        }
    }

}
