package com.example._0_design_patterns.creational.singleton;

// Ensures thread safety and prevents creating another instance even during serialization.
public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }
}
