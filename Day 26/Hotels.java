package com.streams;

public class Hotels {
    private String hotelName;
    private int weekdayRates;
    private int weekendRates;
    private int ratings;

    public Hotels(String hotelName, int weekdayRates, int weekendRates, int ratings) {
        this.hotelName = hotelName;
        this.weekdayRates = weekdayRates;
        this.weekendRates = weekendRates;
        this.ratings = ratings;
    }

    public Hotels() {
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getWeekdayRates() {
        return weekdayRates;
    }

    public void setWeekdayRates(int weekdayRates) {
        this.weekdayRates = weekdayRates;
    }

    public int getWeekendRates() {
        return weekendRates;
    }

    public void setWeekendRates(int weekendRates) {
        this.weekendRates = weekendRates;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Hotels{" +
                "hotelName='" + hotelName + '\'' +
                ", weekdayRates=" + weekdayRates +
                ", weekendRates=" + weekendRates +
                ", ratings=" + ratings +
                '}';
    }
}
