package org.example;
import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
    public static HikariConfig config = new HikariConfig();
   public static HikariDataSource dataSource;

    public static void init() {
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/albums");
        config.setUsername("postgres");
        config.setPassword("password");
        config.setMaximumPoolSize(10000);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(6000000);
        dataSource = new HikariDataSource(config);
    }
    public static Connection getConn(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void closeConnection() {
        try {
            dataSource.getConnection().close();
            System.out.println("Database connection closed.");
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }
}
