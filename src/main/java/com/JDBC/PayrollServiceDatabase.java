package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PayrollServiceDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USER = "root";
    private static final String PASS = "Garv@2404";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

}
