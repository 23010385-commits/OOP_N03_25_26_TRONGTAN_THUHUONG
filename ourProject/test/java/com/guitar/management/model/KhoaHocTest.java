package test;
import models.KhoaHoc;

public class KhoaHocTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        KhoaHoc c1 = new KhoaHoc(1, "Khoa hoc Guitar co ban", "Mo ta", null);

        System.out.println("Thong tin khoa hoc ban dau:");
        System.out.println("Ten khoa hoc: " + c1.getTenKhoaHoc());
        System.out.println("Mo ta: " + c1.getMoTa());

        c1.setTenKhoaHoc("Khoa hoc Guitar nang cao");

        System.out.println("Thong tin khoa hoc sau khi chinh sua:");
        System.out.println("Ten khoa hoc: " + c1.getTenKhoaHoc());
        System.out.println("Mo ta: " + c1.getMoTa());
    }
}
