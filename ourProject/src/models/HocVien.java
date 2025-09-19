package models;

import java.util.ArrayList;
import java.util.Scanner;

// Đối tượng Học viên
class HocVienModel {
    int id;
    String name;
    int age;

    HocVienModel(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Thêm các phương thức getter và setter
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

// CRUD cho Học viên
public class HocVien {
    private int id;
    private String name;
    private int age;

    public HocVien() {
        // Constructor mặc định
    }

    public HocVien(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Thêm các phương thức getter và setter cần thiết
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "HocVien{id=" + id + ", name='" + name + "', age=" + age + "}";
    }

    static ArrayList<HocVienModel> hocViens = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // CREATE - Thêm học viên
    static void createHocVien() {
        System.out.print("Nhập ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();
        hocViens.add(new HocVienModel(id, name, age));
        System.out.println("✅ Đã thêm học viên!");
    }

    // READ - Xem danh sách
    static void readHocViens() {
        System.out.println("Danh sách học viên:");
        for (HocVienModel hv : hocViens) {
            System.out.println(hv.id + " - " + hv.name + " - " + hv.age + " tuổi");
        }
    }

    // UPDATE - Sửa học viên
    static void updateHocVien() {
        System.out.print("Nhập ID học viên cần sửa: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (HocVienModel hv : hocViens) {
            if (hv.getId() == id) {
                System.out.print("Nhập tên mới: ");
                hv.setName(sc.nextLine());
                System.out.print("Nhập tuổi mới: ");
                hv.setAge(sc.nextInt());
                System.out.println("✅ Đã cập nhật!");
                return;
            }
        }
        System.out.println("❌ Không tìm thấy học viên!");
    }

    // DELETE - Xóa học viên
    static void deleteHocVien() {
        System.out.print("Nhập ID học viên cần xóa: ");
        int id = sc.nextInt();
        hocViens.removeIf(hv -> hv.id == id);
        System.out.println("✅ Đã xóa (nếu có)!");
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
                case 1: createHocVien(); break;
                case 2: readHocViens(); break;
                case 3: updateHocVien(); break;
                case 4: deleteHocVien(); break;
                case 0: System.exit(0);
            }
        }
    }
}
