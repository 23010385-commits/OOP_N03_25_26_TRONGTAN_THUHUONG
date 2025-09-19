public class App {
    public static void main(String[] args) {

        // Tạo đối tượng Lesson
        Lesson l1 = new Lesson(1, "Hop am C", "Gioi thieu hop am co ban C", 30);
        Lesson l2 = new Lesson(2, "Dem nhac co ban", "Nhip dieu 4/4 don gian", 40);

        // Gọi phương thức showInfo để hiển thị
        l1.showInfo();
        l2.showInfo();

        HocVien hv1 = new HocVien(1, "Nguyen Van A", 12);
        HocVien hv2 = new HocVien(2, "Tran Thi B", 13);

        // Hiển thị thông tin học viên
        hv1.showInfo();
        hv2.showInfo();
    }
}
