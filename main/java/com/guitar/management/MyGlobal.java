package com.guitar.management;

/**
 * Class này chứa các biến 'toàn cục' (static)
 * để các phần khác của chương trình có thể giao tiếp,
 * ví dụ như để báo lỗi.
 */
public class MyGlobal {

    /**
     * Biến static để theo dõi lỗi.
     * 0 = Mặc định, không có lỗi.
     * -1 = Báo hiệu đã xảy ra lỗi (ví dụ: index mảng bị sai).
     */
    public static int indexError = 0;

    /**
     * Constructor private để ngăn không cho ai tạo đối tượng (new MyGlobal())
     * từ class này, vì nó chỉ dùng để chứa các thành viên static.
     */
    private MyGlobal() {
        // Không cho phép tạo instance
    }

}