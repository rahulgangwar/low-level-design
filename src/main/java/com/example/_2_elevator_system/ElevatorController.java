package com.example._2_elevator_system;

import com.example._2_elevator_system.enums.ElevatorState;
import com.example._2_elevator_system.enums.HallRequestDirection;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class ElevatorController {
    private final int minFloor;
    private final int maxFloor;
    private final List<Elevator> elevators;

    public ElevatorController(int minFloor, int maxFloor, int noOfElevators) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;

        elevators = new ArrayList<>();
        for (int i = 1; i <= noOfElevators; i++) {
            elevators.add(new Elevator(i, 0));
        }
    }

    public Elevator selectElevator(int floor, HallRequestDirection requestDirection) {

        // 1. Prefer an elevator already moving toward the request.
        Elevator movingElevator =
                elevators.stream()
                        .filter(e -> isMovingToward(e, floor, requestDirection))
                        .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - floor)))
                        .orElse(null);

        if (movingElevator != null) {
            return movingElevator;
        }

        // 2. Otherwise, choose the nearest idle elevator.
        Elevator idleElevator =
                elevators.stream()
                        .filter(e -> e.getState() == ElevatorState.IDLE)
                        .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - floor)))
                        .orElse(null);

        if (idleElevator != null) {
            return idleElevator;
        }

        // 3. If none is idle or moving toward the request,
        // choose the nearest elevator.
        return elevators.stream()
                .min(Comparator.comparingInt(e -> Math.abs(e.getCurrentFloor() - floor)))
                .orElseThrow(() -> new IllegalStateException("No elevators available"));
    }

    private boolean isMovingToward(
            Elevator elevator, int requestFloor, HallRequestDirection requestedDirection) {

        if (requestedDirection == HallRequestDirection.UP) {
            return elevator.getState() == ElevatorState.MOVING_UP
                    && elevator.getCurrentFloor() <= requestFloor;
        }

        return elevator.getState() == ElevatorState.MOVING_DOWN
                && elevator.getCurrentFloor() >= requestFloor;
    }
}
