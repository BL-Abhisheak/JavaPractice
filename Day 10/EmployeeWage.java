package com.practice;

public interface EmployeeWage {
    void addCompanyEmpWage(String company, int wagePerHour, int numOfWorkingDays, int maxHoursPerMonth);
    void computeEmpWage();
    int getTotalWage(String company);
}
