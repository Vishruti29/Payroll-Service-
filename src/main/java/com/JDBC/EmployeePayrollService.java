package com.JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeePayrollService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/payroll_service";
    private static final String USER = "root";
    private static final String PASSWORD = "Garv@2404";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public double getSumOfSalaryByGender(String gender) {
        double sum = 0;
        try (Connection connection = getConnection()) {
            String sql = "SELECT SUM(salary) FROM employee_payroll WHERE gender = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sum = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting sum of salary by gender", e);
        }
        return sum;
    }

    public double getAverageSalaryByGender(String gender) {
        double average = 0;
        try (Connection connection = getConnection()) {
            String sql = "SELECT AVG(salary) FROM employee_payroll WHERE gender = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                average = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting average salary by gender", e);
        }
        return average;
    }

    public double getMinSalaryByGender(String gender) {
        double minSalary = 0;
        try (Connection connection = getConnection()) {
            String sql = "SELECT MIN(salary) FROM employee_payroll WHERE gender = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                minSalary = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting minimum salary by gender", e);
        }
        return minSalary;
    }

    public double getMaxSalaryByGender(String gender) {
        double maxSalary = 0;
        try (Connection connection = getConnection()) {
            String sql = "SELECT MAX(salary) FROM employee_payroll WHERE gender = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                maxSalary = resultSet.getDouble(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting maximum salary by gender", e);
        }
        return maxSalary;
    }

    public int getCountByGender(String gender) {
        int count = 0;
        try (Connection connection = getConnection()) {
            String sql = "SELECT COUNT(*) FROM employee_payroll WHERE gender = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, gender);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error getting count by gender", e);
        }
        return count;
    }
}
