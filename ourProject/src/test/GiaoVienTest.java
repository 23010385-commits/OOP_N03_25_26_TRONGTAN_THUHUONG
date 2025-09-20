public class GiaoVienTest {
    public static void main(String[] args) {
        // tao giao vien
        GiaoVien gv1 = new GiaoVien(1, "Tran Thi B", "tranb@gmail.com", "0987654321");

        // in thong tin giao vien
        System.out.println("Thong tin giao vien:");
        System.out.println(gv1);

        // thay doi ten
        gv1.setTen("Le Van C");
        System.out.println("Thong tin sau khi doi ten:");
        System.out.println(gv1);
    }
}
