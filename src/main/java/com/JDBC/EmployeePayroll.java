package com.JDBC;
import java.time.LocalDate;
import java.util.Date;

public class EmployeePayroll {
    private int id;
    private String name;
    private double salary;
    private LocalDate startDate;

    public EmployeePayroll(int id, String name, double salary, LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.startDate = startDate;
    }

    public EmployeePayroll(int id, String name, double salary, Date startDate) {
        this(id, name, salary, startDate.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
