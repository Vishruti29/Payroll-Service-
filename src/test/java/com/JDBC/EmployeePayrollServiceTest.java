package com.JDBC;
import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeePayrollServiceTest {
    @Test
    public void testGetEmployeePayrollList() {
        EmployeePayrollService service = new EmployeePayrollService();
        assertFalse(service.getEmployeePayrollList().isEmpty());
    }

    @Test
    public void testUpdateEmployeeSalary() {
        EmployeePayrollService service = new EmployeePayrollService();
        String name = "DEF";
        double newSalary = 3000000.00;
        service.updateEmployeeSalary(name, newSalary);
        EmployeePayroll employeePayroll = service.getEmployeePayrollByName(name);
        assertEquals(newSalary, employeePayroll.getSalary(), 0.0);
    }
}
