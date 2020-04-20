package com.bridgelabz;

public enum CabRide {
    NORMAL(10.0, 1.0,5.0),
    PREMIUM(15.0, 2.0, 20.0);

    private final double COST_PER_KM;
    private final double COST_PER_MIN;
    private final double MIN_FARE_PER_RIDE;

    CabRide(double costPerKm, double costPerMin, double minFare) {
        this.COST_PER_KM = costPerKm;
        this.COST_PER_MIN = costPerMin;
        this.MIN_FARE_PER_RIDE = minFare;
    }

    public double calcCostOfCabRide(Ride ride) {
        double rideCost = ride.distance * COST_PER_KM + ride.time * COST_PER_MIN;
        return Math.max(rideCost, MIN_FARE_PER_RIDE);
    }
}
