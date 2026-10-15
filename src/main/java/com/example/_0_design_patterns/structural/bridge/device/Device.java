package com.example._0_design_patterns.structural.bridge.device;

// Implementor
public interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int volume);
}
