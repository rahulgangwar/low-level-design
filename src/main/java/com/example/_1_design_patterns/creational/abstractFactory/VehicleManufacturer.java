package com.example._1_design_patterns.creational.abstractFactory;

import com.example._1_design_patterns.creational.abstractFactory.factory.VehicleFactory;
import com.example._1_design_patterns.creational.abstractFactory.vehicle.Vehicle;

public class VehicleManufacturer {

    public Vehicle manufactureVehicle(VehicleFactory<? extends Vehicle> vehicleFactory) {
        return vehicleFactory.create();
    }
}
