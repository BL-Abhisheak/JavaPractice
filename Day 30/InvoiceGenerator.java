package com.ivoice;

public class InvoiceGenerator {

    int fare = 0;

    public int calculateFare(int km, int mins) {
         fare = km * 10 + mins * 1;

        if (fare < 5) {
            fare = 5;
        }

        System.out.println("The total fare is : Rs " + fare);
        return fare;
    }



    public void calculateTotalFare(Ride[] rides) {
        int rideCount = 0;
        int total = 0;
        int averageFare = 0;

        for (Ride r : rides) {
            total += calculateFare(r.getKm(), r.getTime());
            rideCount++;
        }

        averageFare = total / rideCount;

        System.out.println("Total fare for all rides: Rs " + total + "\nThe total number of rides is " + rideCount + "\nThe average fare per ride is " + averageFare);
    }

    public static void main(String[] args) {
        InvoiceGenerator ig = new InvoiceGenerator();
        Ride r1 = new Ride(2,6);
        Ride r2 = new Ride(5,50);
        Ride r3 = new Ride(10,30);

        Ride[] rides = {r1,r2,r3};
        ig.calculateTotalFare(rides);

    }

}
