import models.HocVien;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<HocVien> danhSachHocVien = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // CREATE - thêm học viên
    static void themHocVien() {
        System.out.print("Nhập ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();

        HocVien hv = new HocVien(id, name, age);
        danhSachHocVien.add(hv);
        System.out.println("✅ Đã thêm học viên!");
    }

    // READ - xem danh sách học viên
    static void xemDanhSach() {
        System.out.println("\nDanh sách học viên:");
        for (HocVien hv : danhSachHocVien) {
            System.out.println(hv);
        }
    }

    // UPDATE - sửa thông tin học viên
    static void suaHocVien() {
        System.out.print("Nhập ID học viên cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (HocVien hv : danhSachHocVien) {
            if (hv.getId() == id) { // Sửa lại
                System.out.print("Nhập tên mới: ");
                hv.setName(sc.nextLine()); // Sửa lại
                System.out.print("Nhập tuổi mới: ");
                hv.setAge(sc.nextInt()); // Sửa lại
                System.out.println("✅ Đã sửa thông tin!");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy học viên!");
    }

    // DELETE - xóa học viên
    static void xoaHocVien() {
        System.out.print("Nhập ID học viên cần xóa: ");
        int id = sc.nextInt();

        boolean removed = danhSachHocVien.removeIf(hv -> hv.getId() == id); // Sửa lại
        if (removed) {
            System.out.println("✅ Đã xóa học viên!");
        } else {
            System.out.println("❌ Không tìm thấy học viên!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== MENU QUẢN LÝ HỌC VIÊN ===");
            System.out.println("1. Thêm học viên");
            System.out.println("2. Xem danh sách học viên");
            System.out.println("3. Sửa thông tin học viên");
            System.out.println("4. Xóa học viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> themHocVien();
                case 2 -> xemDanhSach();
                case 3 -> suaHocVien();
                case 4 -> xoaHocVien();
                case 0 -> {
                    System.out.println("👋 Tạm biệt!");
                    return;
                }
                default -> System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }
}
