package com.example._1_design_patterns.creational.abstractFactory.factory;

import com.example._1_design_patterns.creational.abstractFactory.vehicle.Car;

public class CarFactory implements VehicleFactory<Car> {
    @Override
    public Car create() {
        return new Car();
    }
}
