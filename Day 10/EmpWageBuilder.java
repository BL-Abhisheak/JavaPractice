package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpWageBuilder implements EmployeeWage {

    private static final int IS_PART_TIME = 1;
    private static final int IS_FULL_TIME = 2;
    private static final int PART_TIME_HOURS = 4;
    private static final int FULL_TIME_HOURS = 8;

    private final List<CompanyEmpWage> companyEmpWageList;
    private final Map<String, CompanyEmpWage> companyToEmpWageMap;

    public EmpWageBuilder() {
        companyEmpWageList = new ArrayList<>();
        companyToEmpWageMap = new HashMap<>();
    }

    @Override
    public void addCompanyEmpWage(String company, int wagePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, wagePerHour, numOfWorkingDays, maxHoursPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyToEmpWageMap.put(company, companyEmpWage);
    }

    @Override
    public void computeEmpWage() {
        for (CompanyEmpWage companyEmpWage : companyEmpWageList) {
            int totalWage = computeEmpWageForCompany(companyEmpWage);
            companyEmpWage.setTotalWage(totalWage);
            System.out.println(companyEmpWage);
        }
    }

    private int computeEmpWageForCompany(CompanyEmpWage companyEmpWage) {
        int totalEmpHrs = 0;
        int totalWorkingDays = 0;
        int totalWage = 0;

        System.out.println("\nComputing wages for company: " + companyEmpWage.company);

        while (totalEmpHrs < companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) (Math.random() * 3); // 0,1,2
            int empHrs;
            switch (empCheck) {
                case IS_PART_TIME:
                    empHrs = PART_TIME_HOURS;
                    break;
                case IS_FULL_TIME:
                    empHrs = FULL_TIME_HOURS;
                    break;
                default:
                    empHrs = 0; // absent
            }

            if (totalEmpHrs + empHrs > companyEmpWage.maxHoursPerMonth) {
                empHrs = companyEmpWage.maxHoursPerMonth - totalEmpHrs;
            }

            totalEmpHrs += empHrs;
            int empWage = empHrs * companyEmpWage.wagePerHour;
            totalWage += empWage;
            companyEmpWage.addDailyWage(empWage);

            System.out.println("Day#: " + totalWorkingDays +
                    " | EmpHrs: " + empHrs +
                    " | DailyWage: " + empWage +
                    " | TotalHrsSoFar: " + totalEmpHrs);
        }

        System.out.println("Total working days: " + totalWorkingDays + ", Total hours: " + totalEmpHrs);
        System.out.println("Total wage for company " + companyEmpWage.company + " = " + totalWage);
        return totalWage;
    }

    @Override
    public int getTotalWage(String company) {
        CompanyEmpWage c = companyToEmpWageMap.get(company);
        if (c != null) return c.getTotalWage();
        System.out.println("Company not found: " + company);
        return -1;
    }

    public List<Integer> getDailyWages(String company) {
        CompanyEmpWage c = companyToEmpWageMap.get(company);
        if (c != null) return c.getDailyWages();
        return new ArrayList<>();
    }
}

