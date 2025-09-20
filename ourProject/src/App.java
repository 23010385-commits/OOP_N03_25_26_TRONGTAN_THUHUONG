import java.util.Date;

public class App {
    public static void main(String[] args) {
        // tao bai hoc
        Baihoc bh1 = new Baihoc(1, "Java OOP", "Huong doi tuong co ban");
        Baihoc bh2 = new Baihoc(2, "Java Collection", "List, Map, Set");

        // tao khoa hoc
        Khoahoc khoahoc = new Khoahoc();
        khoahoc.themBaihoc(bh1);
        khoahoc.themBaihoc(bh2);

        // tao hoc vien
        Hocvien hv = new Hocvien("Nguyen Van A", 1);

        // tao giao vien
        Giaovien gv = new Giaovien("Tran Thi B");

        // giao bai hoc cho hoc vien
        gv.Giaobai(hv, bh1);

        // hoc vien hoc bai
        hv.hocBai(bh1);
        hv.thiThu();
        hv.levelUp();

        // giao bai hoc thu 2
        gv.Giaobai(hv, bh2);
        hv.hocBai(bh2);

        // test lay bai hoc theo level
        Baihoc bhTheoLevel = khoahoc.layBaiHocTheoLevel(1);
        System.out.println("Bai hoc level 1: " + bhTheoLevel.getNoidung());

        // in thong tin
        System.out.println("Hoc vien: " + hv.getTen() + " - level: " + hv.getLevel());
        System.out.println("Giao vien: " + gv.getTen());
    }
}
