package com.bridgelabz;

public class InvoiceService {
    private static final int NORMAL_COST_PER_MINUTE = 1;
    private static final double NORMAL_MINIMUM_COST_PER_KILOMETER = 10;
    private static final double NORMAL_MINIMUM_FARE = 5;

    private static final int PREMIUM_COST_PER_MINUTE = 2;
    private static final double PREMIUM_MINIMUM_COST_PER_KILOMETER = 15;
    private static final double PREMIUM_MINIMUM_FARE = 20;
    private RideRepository rideRepository;

    public InvoiceService() {
        this.rideRepository = new RideRepository();
    }

    public double calculateFare(Ride.RideType rideType, double distance, int time) {
        double totalFare = 0;
        if(rideType == Ride.RideType.NORMAL) {
            totalFare =  distance * NORMAL_MINIMUM_COST_PER_KILOMETER + time * NORMAL_COST_PER_MINUTE;
            return Math.max(totalFare, NORMAL_MINIMUM_FARE);
        }
        totalFare = distance * PREMIUM_MINIMUM_COST_PER_KILOMETER + time * PREMIUM_COST_PER_MINUTE;
        return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.rideType, ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
