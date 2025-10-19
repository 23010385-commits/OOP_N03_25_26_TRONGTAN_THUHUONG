package com.guitar.management.database;

import org.springframework.stereotype.Controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.lang.Class;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Value;

@Controller
public class DatabaseConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://avnadmin:AVNS_XxatIKHtVMpyJCELCO6@mysql-2d351bba-nngocduy2512-2de2.b.aivencloud.com:10614/defaultdb?ssl-mode=REQUIRED";
        String user = "avnadmin";
        String password = "AVNS_XxatIKHtVMpyJCELCO6";
        Connection conn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (Exception ex) {
                System.out.println("Error closing connection: " + ex.getMessage());
            }
        }

    }



    public DatabaseConnection() {
    };
    // @Value("${my.database.url}")
    // protected String myDatabaseURL;
    String myDatabaseURL = "jdbc:mysql://avnadmin:AVNS_XxatIKHtVMpyJCELCO6@mysql-2d351bba-nngocduy2512-2de2.b.aivencloud.com:10614/defaultdb?ssl-mode=REQUIRED";
    // @Value("${my.database.driver}")
    // protected String myDatabaseDriver;
    String myDatabaseDriver = "com.mysql.cj.jdbc.Driver";
    public Connection conn = null;
    public Statement getMyConn() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL);
            Statement sta = conn.createStatement();
            return sta;
        } catch (Exception e) {
            System.out.println("DatabaseConnection at 34" + e);
        }
        return null;
    }
    public Connection getOnlyConn() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL);
            return conn;
        } catch (Exception e) {
            System.out.println("Database connection error: " + e);
        }
        return conn;
    }
}
