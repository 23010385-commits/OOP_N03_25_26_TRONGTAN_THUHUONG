package test;
import models.KhoaHoc;

public class KhoaHocTest {

    public static void test(){

        KhoaHoc c1 = new KhoaHoc(1, "Khoa hoc Guitar co ban");

        System.out.println("Thong tin khoa hoc ban dau:");
        System.out.println(c1);

        c1.setName("Khoa hoc Guitar nang cao");

        System.out.println("Thong tin khoa hoc sau khi chinh sua:");
        System.out.println(c1);

    }

}
