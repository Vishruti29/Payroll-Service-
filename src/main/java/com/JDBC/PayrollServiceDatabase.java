package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PayrollServiceDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service"; // URL
    private static final String USER = "root"; // ID
    private static final String PASS = "Garv@2404"; // Password
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
