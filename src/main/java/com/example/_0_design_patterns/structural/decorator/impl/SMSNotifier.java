package com.example._0_design_patterns.structural.decorator.impl;

import com.example._0_design_patterns.structural.decorator.core.Notifier;
import com.example._0_design_patterns.structural.decorator.core.NotifierDecorator;

// Concrete Decorator - SMS Notifier
public class SMSNotifier extends NotifierDecorator {
    public SMSNotifier(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}



