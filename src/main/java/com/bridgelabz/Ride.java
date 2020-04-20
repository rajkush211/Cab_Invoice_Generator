package com.bridgelabz;

public class Ride {

    public enum RideType {NORMAL, PREMIUM};
    public RideType rideType;
    public double distance;
    public int time;

    public Ride(RideType rideType, double distance, int time) {
        this.rideType = rideType;
        this.distance = distance;
        this.time = time;
    }
}
