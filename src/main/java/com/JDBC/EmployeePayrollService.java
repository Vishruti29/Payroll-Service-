package com.JDBC;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {
    private final String url = "jdbc:mysql://localhost:3306/payroll_service";
    private final String user = "root";
    private final String password = "Garv@2404";

    public List<EmployeePayroll> getEmployeePayrollList() {
        try {
            List<EmployeePayroll> employeePayrollList = new ArrayList<>();
            String sql = "SELECT * FROM employee_payroll";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    double salary = rs.getDouble("salary");
                    LocalDate startDate = rs.getDate("start_date").toLocalDate();
                    EmployeePayroll employeePayroll = new EmployeePayroll(id, name, salary, startDate);
                    employeePayrollList.add(employeePayroll);
                }
            }
            return employeePayrollList;
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving employee payroll data: " + e.getMessage());
        }
    }

    public void updateEmployeeSalary(String name, double salary) {
        try {
            String sql = "UPDATE employee_payroll SET salary=? WHERE name=?";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, salary);
                pstmt.setString(2, name);
                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated == 0) {
                    throw new EmployeeNotFoundException("Employee " + name + " not found");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error updating employee payroll data: " + e.getMessage());
        }
    }

    public EmployeePayroll getEmployeePayrollByName(String name) {
        try {
            String sql = "SELECT * FROM employee_payroll WHERE name=?";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("id");
                        double salary = rs.getDouble("salary");
                        LocalDate startDate = rs.getDate("start_date").toLocalDate();
                        return new EmployeePayroll(id, name, salary, startDate);
                    } else {
                        throw new EmployeeNotFoundException("Employee " + name + " not found");
                    }
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException("Error retrieving employee payroll data: " + e.getMessage());
        }
    }

    class DatabaseException extends RuntimeException {
        public DatabaseException(String message) {
            super(message);
        }
    }

    class EmployeeNotFoundException extends RuntimeException {
        public EmployeeNotFoundException(String message) {
            super(message);
        }
    }
}
