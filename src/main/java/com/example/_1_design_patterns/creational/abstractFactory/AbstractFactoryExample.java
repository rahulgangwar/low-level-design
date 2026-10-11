package com.example._1_design_patterns.creational.abstractFactory;

import com.example._1_design_patterns.creational.abstractFactory.factory.BikeFactory;
import com.example._1_design_patterns.creational.abstractFactory.factory.CarFactory;
import com.example._1_design_patterns.creational.abstractFactory.factory.VehicleFactory;
import com.example._1_design_patterns.creational.abstractFactory.vehicle.Bike;
import com.example._1_design_patterns.creational.abstractFactory.vehicle.Car;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        VehicleFactory<Car> carFactory = new CarFactory();
        VehicleFactory<Bike> bikeFactory = new BikeFactory();

        System.out.println(new VehicleManufacturer().manufactureVehicle(carFactory));
        System.out.println(new VehicleManufacturer().manufactureVehicle(bikeFactory));

    }
}
