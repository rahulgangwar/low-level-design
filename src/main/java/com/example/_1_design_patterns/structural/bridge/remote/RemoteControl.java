package com.example._1_design_patterns.structural.bridge.remote;

import com.example._1_design_patterns.structural.bridge.device.Device;

// Abstraction
public abstract class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

    public void setVolume(int volume) {
        device.setVolume(volume);
    }
}
