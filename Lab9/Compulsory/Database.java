package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
        private static final String URL = "jdbc:postgresql://localhost:5432/albums";
        private static final String USER = "postgres";
        private static final String PASSWORD = "password";
        private static Connection connection = null;
        private Database() {
            //createConnection();
        }
        public static Connection getConnection() {
            return connection;
        }
        public static void createConnection() {
            try {
                connection = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                System.err.println("Cannot connect to DB: " + e);
            }
        }
        public static void closeConnection() {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }

    public static void rollback() {
    }
}
