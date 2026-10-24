package com.example.parking_lot.space;


import com.example.parking_lot.vehicle.Vehicle;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> parkingFloors;

    private ParkingLot() {
        parkingFloors = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.parkVehicle(vehicle)) {
                System.out.println("Vehicle parked successfully.");
                return true;
            }
        }
        System.out.println("Could not park vehicle.");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingFloor parkingFloor : parkingFloors) {
            if (parkingFloor.unparkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void getAvailableSpots() {
        for (ParkingFloor parkingFloor : parkingFloors) {
            parkingFloor.displayAvailability();
        }
    }
}