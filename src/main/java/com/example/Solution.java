package com.example;

import java.util.ArrayList;

public class Solution {
    public class Singleton {
        private volatile Singleton instance;

        public Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            new ArrayList<>().clone();
            return instance;
        }

    }
}
