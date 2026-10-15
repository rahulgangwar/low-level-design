package com.example._0_design_patterns.creational.abstractFactory.factory;

import com.example._0_design_patterns.creational.abstractFactory.vehicle.Bike;

public class BikeFactory implements VehicleFactory<Bike> {
    @Override
    public Bike create() {
        return new Bike();
    }
}
