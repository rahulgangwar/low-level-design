package com.example.parking_lot;

import com.example.parking_lot.space.ParkingFloor;
import com.example.parking_lot.space.ParkingLot;
import com.example.parking_lot.vehicle.Car;
import com.example.parking_lot.vehicle.Motorcycle;
import com.example.parking_lot.vehicle.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addParkingFloor(new ParkingFloor(1, 100));
        parkingLot.addParkingFloor(new ParkingFloor(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle motorcycle = new Motorcycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.getAvailableSpots();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        // Display updated availability
        parkingLot.getAvailableSpots();
    }
}
