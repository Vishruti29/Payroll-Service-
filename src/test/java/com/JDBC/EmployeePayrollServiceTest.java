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
        double oldSalary = service.getEmployeePayrollByName(name).getSalary();
        double newSalary = 3000000.00;
        service.updateEmployeeSalary(name, newSalary);
        assertEquals(newSalary, service.getEmployeePayrollByName(name).getSalary(), 0.0);
        service.updateEmployeeSalary(name, oldSalary);
        assertEquals(oldSalary, service.getEmployeePayrollByName(name).getSalary(), 3000000.00);
    }
}