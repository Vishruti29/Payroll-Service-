package com.JDBC;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class EmployeePayrollServiceTest {
    @Test
    public void testGetEmployeePayrollList() {
        EmployeePayrollService service = new EmployeePayrollService();
        List<EmployeePayroll> employeePayrollList = service.getEmployeePayrollList();
        assertNotNull(employeePayrollList);
        assertFalse(employeePayrollList.isEmpty());
    }
}
