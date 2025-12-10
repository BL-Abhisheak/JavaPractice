package com.ivoice;

public class Ride {
    int km;
    int time;

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Ride(int km, int time) {
        this.km = km;
        this.time = time;
    }

    public Ride() {
    }
}
