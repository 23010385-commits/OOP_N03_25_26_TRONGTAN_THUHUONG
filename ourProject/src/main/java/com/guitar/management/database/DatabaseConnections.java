package com.guitar.management.database;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@Component
public class DatabaseConnections {

    @Value("${spring.datasource.url}")
    private String myDatabaseURL;

    @Value("${spring.datasource.driver-class-name}")
    private String myDatabaseDriver;

    @Value("${spring.datasource.username}")
    private String myDatabaseUser;

    @Value("${spring.datasource.password}")
    private String myDatabasePassword;

    private Connection conn;

    public Statement getStatement() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL, myDatabaseUser, myDatabasePassword);
            return conn.createStatement();
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return null;
    }

    public Connection getConnection() {
        try {
            Class.forName(myDatabaseDriver);
            conn = DriverManager.getConnection(myDatabaseURL, myDatabaseUser, myDatabasePassword);
            return conn;
        } catch (Exception e) {
            System.out.println("Database connection error: " + e.getMessage());
        }
        return null;
    }
}
