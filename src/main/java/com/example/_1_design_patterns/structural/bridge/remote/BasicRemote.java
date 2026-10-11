package com.example._1_design_patterns.structural.bridge.remote;

import com.example._1_design_patterns.structural.bridge.device.Device;

// Refined Abstraction 1
public class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Muting device...");
        device.setVolume(0);
    }
}