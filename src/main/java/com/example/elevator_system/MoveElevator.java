package com.example.elevator_system;

public class MoveElevator implements Runnable {
    private Elevator elevator;

    public MoveElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        while (!elevator.isIdle()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elevator.move();
        }
    }
}
