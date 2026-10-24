package com.example._2_elevator_system;

import com.example._2_elevator_system.enums.ElevatorState;

import lombok.Data;

import java.util.NavigableSet;
import java.util.TreeSet;

@Data
public class Elevator {
    private int id;
    private ElevatorState state;
    private int currentFloor;

    private NavigableSet<Integer> upStops = new TreeSet<>();
    private NavigableSet<Integer> downStops = new TreeSet<>((a, b) -> Integer.compare(b, a));

    public Elevator(int id, int initialFloor) {
        this.id = id;
        this.currentFloor = initialFloor;
    }

    public boolean isIdle() {
        return upStops.isEmpty() && downStops.isEmpty();
    }

    public void addDestination(int floorNo) {
        if (currentFloor == floorNo) return;

        if (floorNo > currentFloor) {
            upStops.add(floorNo);
        } else {
            downStops.add(floorNo);
        }

        if (state == ElevatorState.IDLE) {
            state = floorNo > currentFloor ? ElevatorState.MOVING_UP : ElevatorState.MOVING_DOWN;
        }
    }

    public void move() {
        if (state == ElevatorState.IDLE) {
            return;
        } else if (state == ElevatorState.MOVING_UP) {
            if (!upStops.isEmpty()) {
                currentFloor++;
                upStops.remove(currentFloor);
            } else if (!downStops.isEmpty()) {
                state = ElevatorState.MOVING_DOWN;
            }
        } else {
            if (!downStops.isEmpty()) {
                currentFloor--;
                downStops.remove(currentFloor);
            } else if (!upStops.isEmpty()) {
                state = ElevatorState.MOVING_UP;
            }
        }
        System.out.println("Elevator: " + id + " - " + state.name() + " Floor No: " + currentFloor);

        if (upStops.isEmpty() && downStops.isEmpty()) {
            state = ElevatorState.IDLE;
        }
    }
}
