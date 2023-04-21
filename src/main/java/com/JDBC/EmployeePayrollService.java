package com.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USER = "root";
    private static final String PASSWORD = "Garv@2404";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public List<EmployeePayroll> getEmployeePayrollList() {
        List<EmployeePayroll> employeePayrollList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM employee_payroll";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
                employeePayrollList.add(new EmployeePayroll(id, name, salary, startDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employee payroll list", e);
        }
        return employeePayrollList;
    }

    public List<EmployeePayroll> getEmployeePayrollListByDateRange(LocalDate startDate, LocalDate endDate) {
        List<EmployeePayroll> employeePayrollList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM employee_payroll WHERE start_date BETWEEN ? AND ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, Date.valueOf(startDate));
            statement.setDate(2, Date.valueOf(endDate));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salary = resultSet.getDouble("salary");
                LocalDate joinDate = resultSet.getDate("start_date").toLocalDate();
                employeePayrollList.add(new EmployeePayroll(id, name, salary, joinDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employee payroll list by date range", e);
        }
        return employeePayrollList;
    }
}
