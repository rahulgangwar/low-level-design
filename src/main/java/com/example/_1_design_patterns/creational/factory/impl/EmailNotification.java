package com.example._1_design_patterns.creational.factory.impl;

import com.example._1_design_patterns.creational.factory.core.Notification;

// Concrete Product: Email Notification
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email Notification");
    }
}


