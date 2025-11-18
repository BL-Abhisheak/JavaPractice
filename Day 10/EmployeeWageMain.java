package com.practice;

public class EmployeeWageMain {

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageBuilder empWageBuilder = new EmpWageBuilder();


        empWageBuilder.addCompanyEmpWage("Dmart", 20, 20, 100);
        empWageBuilder.addCompanyEmpWage("Reliance", 25, 22, 120);
        empWageBuilder.addCompanyEmpWage("TCS", 30, 18, 90);

        empWageBuilder.computeEmpWage();

        System
                .out.println("\nQuery total wage by company:");
        System.out.println("Dmart Total Wage = " + empWageBuilder.getTotalWage("Dmart"));
        System.out.println("Reliance Total Wage = " + empWageBuilder.getTotalWage("Reliance"));
        System.out.println("TCS Total Wage = " + empWageBuilder.getTotalWage("TCS"));

        System.out.println("\nDaily wages for Dmart: " + empWageBuilder.getDailyWages("Dmart"));
        System.out.println("Daily wages for Reliance: " + empWageBuilder.getDailyWages("Reliance"));
        System.out.println("Daily wages for TCS: " + empWageBuilder.getDailyWages("TCS"));

        System.out.println("\nThank You");
    }
}

