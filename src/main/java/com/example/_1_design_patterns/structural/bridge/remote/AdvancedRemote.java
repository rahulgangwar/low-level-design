package com.example._1_design_patterns.structural.bridge.remote;

import com.example._1_design_patterns.structural.bridge.device.Device;

// Refined Abstraction 2
public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void setMaxVolume() {
        System.out.println("Setting max volume...");
        device.setVolume(100);
    }
}
