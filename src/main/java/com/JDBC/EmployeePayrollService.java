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
    }

    class DatabaseException extends RuntimeException {
        public DatabaseException(String message) {
            super(message);
        }

}
