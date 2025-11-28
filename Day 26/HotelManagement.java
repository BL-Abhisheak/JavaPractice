package com.streams;

import com.regex.InvalidUserDetailsException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HotelManagement {

    static  ArrayList<Hotels> hotels = new ArrayList<>();

    public static void createHotel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the hotel name : ");
        String hName = sc.nextLine();
        System.out.println("Enter the weekday rates : ");
        int weekdayRate = sc.nextInt();
        System.out.println("Enter the weekend rates :");
        int weekendRate = sc.nextInt();
        System.out.println("Enter the rating for the hotel : (1 TO 5)");
        int ratings = sc.nextInt();

        Hotels h1 = new Hotels(hName,weekdayRate,weekendRate,ratings);
        hotels.add(h1);
        System.out.println("HOTEL CREATED SUCCESSFULLY!!!");

    }

    public static void displayHotels(){
        List<Hotels> allHotels = hotels.stream().collect(Collectors.toUnmodifiableList());
        System.out.println(allHotels);
    }

    public static void validateCustomerType(String customerType) throws InvalidUserDetailsException {
        if (customerType.equalsIgnoreCase("regular") || customerType.equalsIgnoreCase("rewards")){
            System.out.println("Valid customer type");
        }
        else {
            throw new InvalidUserDetailsException("INVALID CUSTOMER TYPE");
        }
    }

    public static boolean validateDate(String date){
        String dateRegex = "^(0[1-9]|[12][0-9]|3[01])(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec)(?-i)(1|2)[0-9]{3}$";
        return Pattern.matches(dateRegex,date);
    }


    /**
     * Converts a date in format "11Sep2020" into LocalDate
     */
    public static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    /**
     * Converts a variable number of date strings into a List<LocalDate>
     * Example: parseDateRange("11Sep2020", "12Sep2020")
     */
    public static List<LocalDate> parseDateRange(String... dateArray) {
        List<LocalDate> dateList = new ArrayList<>();

        for (String date : dateArray) {
            if (!validateDate(date)) {
                throw new IllegalArgumentException("Invalid date format: " + date);
            }
            dateList.add(parseDate(date));
        }

        return dateList;
    }

    /**
     * Checks if a given date is a weekend (Saturday or Sunday)
     */
    public static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }


    //find the total cost of a hotel
    public static int totalCostForOneHotel(Hotels hotel, List<LocalDate> dates, String customerType){
        int totalCost = 0;
        for (LocalDate d : dates){
            if (isWeekend(d)){
                totalCost+= hotel.getWeekendRates();
            }
            else {
                totalCost+= hotel.getWeekdayRates();
            }
        }
        return totalCost;
    }


    //find the cheapest hotel in the list
    public static Hotels calculateCheapestHotel(String startDate, String endDate, String customerType) throws Exception {

        List<LocalDate> allDates = parseDateRange(startDate, endDate);

        validateCustomerType(customerType);

        Hotels cheapestHotel = null;
        int lowestCost = Integer.MAX_VALUE;

        for (Hotels h : hotels) {
            int cost = totalCostForOneHotel(h, allDates, customerType);

            if (cost < lowestCost) {
                lowestCost = cost;
                cheapestHotel = h;
            }
        }

        System.out.println("Cheapest hotel is: " + cheapestHotel.getHotelName()
                + " | Total Cost = " + lowestCost);

        return cheapestHotel;
    }


    public static void main(String[] args) {
        createHotel();
        displayHotels();

    }

}
