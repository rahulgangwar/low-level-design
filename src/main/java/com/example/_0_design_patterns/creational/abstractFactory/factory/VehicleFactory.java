package com.example._0_design_patterns.creational.abstractFactory.factory;

import com.example._0_design_patterns.creational.abstractFactory.vehicle.Vehicle;

public interface VehicleFactory<T extends Vehicle> {
    T create();
}
