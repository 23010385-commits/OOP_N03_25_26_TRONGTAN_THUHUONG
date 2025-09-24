
import models.Lesson;
import models.KhoaHoc;
import models.HocVien;
import models.GiaoVien;

public class App {
    public static void main(String[] args) {
        // tao bai hoc
        Lesson bh1 = new Lesson(1, "Java OOP", "Huong doi tuong co ban", 60);
        Lesson bh2 = new Lesson(2, "Java Collection", "List, Map, Set", 45);

        // tao khoa hoc
        KhoaHoc khoahoc = new KhoaHoc(1, "Khoa hoc Java", "Mo ta", null);
        khoahoc.themBaiHoc(bh1);
        khoahoc.themBaiHoc(bh2);

        // tao hoc vien
        HocVien hv = new HocVien(1, "Nguyen Van A", "a@gmail.com", "0123456789");

        // tao giao vien
        GiaoVien gv = new GiaoVien(2, "Tran Thi B", 35, "Java");

        // giao bai hoc cho hoc vien
        // Nếu có phương thức giaoBai thì gọi, nếu không thì bỏ qua dòng này
        // gv.giaoBai(hv, bh1);

        // hoc vien hoc bai
        // Nếu có phương thức hocBai, thiThu, levelUp thì gọi, nếu không thì bỏ qua dòng này
        // hv.hocBai(bh1);
        // hv.thiThu();
        // hv.levelUp();

        // giao bai hoc thu 2
        // gv.giaoBai(hv, bh2);
        // hv.hocBai(bh2);

        // test lay bai hoc theo level
        // Nếu có phương thức layBaiHocTheoLevel thì gọi, nếu không thì bỏ qua dòng này
        // Lesson bhTheoLevel = khoahoc.layBaiHocTheoLevel(1);
        // System.out.println("Bai hoc level 1: " + bhTheoLevel.getNoiDung());

        // in thong tin
        System.out.println("Hoc vien: " + hv.getTen());
        System.out.println("Giao vien: " + gv.getTen());
    }
}
