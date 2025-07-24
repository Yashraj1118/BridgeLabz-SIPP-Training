package com.bridgelabz;

interface IRideService {
    void bookRide(double distance);
    void endRide();
}

abstract class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public abstract double getRatePerKm();

    public abstract double getBaseFare();
}

class Mini extends Vehicle {
    public Mini(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Mini");
    }

    @Override
    public double getRatePerKm() {
        return 8.0;
    }

    @Override
    public double getBaseFare() {
        return 50.0;
    }
}

class Sedan extends Vehicle {
    public Sedan(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "Sedan");
    }

    @Override
    public double getRatePerKm() {
        return 12.0;
    }

    @Override
    public double getBaseFare() {
        return 80.0;
    }
}

class SUV extends Vehicle {
    public SUV(String vehicleNumber, int capacity) {
        super(vehicleNumber, capacity, "SUV");
    }

    @Override
    public double getRatePerKm() {
        return 15.0;
    }

    @Override
    public double getBaseFare() {
        return 100.0;
    }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public double getRating() {
        return rating;
    }
}

class Ride implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private String currentLocation;
    private double fare;

    public Ride(Vehicle vehicle, Driver driver, String startLocation) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.currentLocation = startLocation;
        this.fare = 0.0;
    }

    @Override
    public void bookRide(double distance) {
        fare = vehicle.getBaseFare() + distance * vehicle.getRatePerKm();
        System.out.println("Ride booked with driver " + driver.getName());
        System.out.println("Vehicle Type: " + vehicle.getType());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Estimated Fare: " + fare);
    }

    @Override
    public void endRide() {
        System.out.println("Ride ended. Total fare: " + fare);
        fare = 0.0;
    }

    public double getFare() {
        return fare;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }
}

public class CabGo {
    public static void main(String[] args) {
        Vehicle vehicle = new Sedan("MH12AB1234", 4);
        Driver driver = new Driver("Rohan Mehta", "DL123456", 4.8);

        Ride ride = new Ride(vehicle, driver, "Pune Station");
        ride.bookRide(15.0);
        ride.endRide();
    }
}







