package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
    private final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    private final String USER = "root";
    private final String PASSWORD = "Garv@2404";

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
                String startDate = resultSet.getString("start_date");
                employeePayrollList.add(new EmployeePayroll(id, name, salary, LocalDate.parse(startDate)));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employee payroll list", e);
        }
        return employeePayrollList;
    }

    public EmployeePayroll getEmployeePayrollByName(String name) {
        EmployeePayroll employeePayroll = null;
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM employee_payroll WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String startDate = resultSet.getString("start_date");
                employeePayroll = new EmployeePayroll(id, name, salary, LocalDate.parse(startDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving employee payroll for name: " + name, e);
        }
        return employeePayroll;
    }

    public void updateEmployeeSalary(String name, double newSalary) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE employee_payroll SET salary = ? WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1, newSalary);
            statement.setString(2, name);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated == 0) {
                throw new RuntimeException("Failed to update employee payroll with name: " + name);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating employee payroll with name: " + name, e);
        }
    }
}
