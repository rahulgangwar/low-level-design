package com.example._2_elevator_system;

import com.example._2_elevator_system.enums.HallRequestDirection;

public class ElevatorDemo {
    public static void main(String[] args) throws InterruptedException {
        ElevatorController controller = new ElevatorController(0, 14, 2);
        Elevator elevator = controller.selectElevator(5, HallRequestDirection.UP);
        elevator.addDestination(10);
        elevator.addDestination(5);
    }
}
