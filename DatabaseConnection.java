package com.guitar.management.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simple JDBC helper for obtaining a Connection to the MySQL database.
 *
 * Notes:
 * - Reads configuration from environment variables DB_URL, DB_USER, DB_PASSWORD
 *   with sensible defaults.
 * - Registers the MySQL JDBC driver once on class load.
 * - Provides a throwing {@link #getConnection()} and a safe {@link #getConnectionSafe()}.
 * - Keeps no long-lived single Connection (prefer using a connection pool in production).
 */
public final class DatabaseConnection {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

    // Read from environment with defaults suitable for local development
    private static final String URL = System.getenv().getOrDefault("DB_URL", "jdbc:mysql://localhost:3306/guitar_management?serverTimezone=UTC");
    private static final String USER = System.getenv().getOrDefault("DB_USER", "root");
    private static final String PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "password");

    static {
        try {
            // Register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "MySQL JDBC Driver not found on classpath", e);
        }
    }

    private DatabaseConnection() { /* utility class */ }

    /**
     * Return a new Connection. Caller is responsible for closing it.
     * This method throws SQLException so callers can handle failures explicitly.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Safe variant: returns a Connection or null on failure and logs the error.
     */
    public static Connection getConnectionSafe() {
        try {
            return getConnection();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Failed to obtain DB connection", e);
            return null;
        }
    }

    /**
     * Close a connection quietly (null-safe).
     */
    public static void closeQuietly(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Error closing connection", e);
            }
        }
    }

    /**
     * Quick helper to test connectivity.
     */
    public static boolean testConnection() {
        try (Connection c = getConnection()) {
            return c != null && !c.isClosed();
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DB connectivity test failed", e);
            return false;
        }
    }
}