package com.JDBC;
import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeePayrollServiceTest {
    private static EmployeePayrollService service;

    @BeforeClass
    public static void setUp() {
        service = new EmployeePayrollService();
    }

    @Test
    public void givenDateRange_WhenRetrievingEmployeePayrollList_ThenReturnCorrectList() {
        LocalDate startDate = LocalDate.of(2022, 1, 1);
        LocalDate endDate = LocalDate.of(2022, 12, 31);
        List<EmployeePayroll> payrollList = service.getEmployeePayrollListByDateRange(startDate, endDate);
        assertEquals(3, payrollList.size());
    }
}
