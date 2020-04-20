package com.bridgelabz;

public class InvoiceGenerator {
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10;
    private static final double MINIMUM_FARE = 5;

    public double calculateFare(double distance, int time) {
        double totalfare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_MINUTE;
        return (totalfare < MINIMUM_FARE) ? MINIMUM_FARE : totalfare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }
}
