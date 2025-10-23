package com.guitar.management.database;

import org.springframework.stereotype.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Controller
public class DatabaseConnection {

    // Thông tin kết nối Aiven MySQL
    private static final String URL = "jdbc:mysql://mysql-2d351bba-nngocduy2512-2de2.b.aivencloud.com:10614/defaultdb?ssl-mode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_Xxat" + "IKHtVMpyJCELCO6";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public DatabaseConnection() {}

    // Hàm kiểm tra kết nối
    public boolean checkConnection() {
        try (Connection conn = getOnlyConn()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Kết nối đến cơ sở dữ liệu Aiven thành công!");
                return true;
            } else {
                System.out.println("Kết nối thất bại (conn = null hoặc đã đóng).");
            }
        } catch (Exception e) {
            System.out.println("⚠️ Lỗi khi kiểm tra kết nối: " + e.getMessage());
        }
        return false;
    }

    // Hàm lấy Statement
    public Statement getMyConn() {
        try {
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn.createStatement();
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi tạo Statement: " + e.getMessage());
        }
        return null;
    }

    // Hàm lấy Connection
    public Connection getOnlyConn() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return null;
    }

    // Test trực tiếp
    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        db.checkConnection();
    }
}
