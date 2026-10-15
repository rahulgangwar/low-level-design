package com.example._0_design_patterns.structural.bridge;

import com.example._0_design_patterns.structural.bridge.device.Device;
import com.example._0_design_patterns.structural.bridge.device.Radio;
import com.example._0_design_patterns.structural.bridge.device.TV;
import com.example._0_design_patterns.structural.bridge.remote.AdvancedRemote;
import com.example._0_design_patterns.structural.bridge.remote.BasicRemote;
import com.example._0_design_patterns.structural.bridge.remote.RemoteControl;

public class BridgePatternExample {
    public static void main(String[] args) {
        // TV with Basic Remote
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemote(tv);
        basicRemote.turnOn();
        basicRemote.setVolume(20);
        ((BasicRemote) basicRemote).mute();
        basicRemote.turnOff();

        System.out.println("-------------------");

        // Radio with Advanced Remote
        Device radio = new Radio();
        RemoteControl advancedRemote = new AdvancedRemote(radio);
        advancedRemote.turnOn();
        advancedRemote.setVolume(50);
        ((AdvancedRemote) advancedRemote).setMaxVolume();
        advancedRemote.turnOff();
    }
}
