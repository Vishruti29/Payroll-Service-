package com.JDBC;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeePayrollServiceTest {

    @Test
    void testGetSumOfSalaryByGender() {
        EmployeePayrollService service = new EmployeePayrollService();
        double expected = 50000.0;
        double actual = service.getSumOfSalaryByGender("M");
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetAverageSalaryByGender() {
        EmployeePayrollService service = new EmployeePayrollService();
        double expected = 50000.0;
        double actual = service.getAverageSalaryByGender("M");
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetMinSalaryByGender() {
        EmployeePayrollService service = new EmployeePayrollService();
        double expected = 50000.0;
        double actual = service.getMinSalaryByGender("M");
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetMaxSalaryByGender() {
        EmployeePayrollService service = new EmployeePayrollService();
        double expected = 50000.0;
        double actual = service.getMaxSalaryByGender("M");
        assertEquals(expected, actual, 0.001);
    }

    @Test
    void testGetCountByGender() {
        EmployeePayrollService service = new EmployeePayrollService();
        int expected = 1;
        int actual = service.getCountByGender("M");
        assertEquals(expected, actual);
    }
}
