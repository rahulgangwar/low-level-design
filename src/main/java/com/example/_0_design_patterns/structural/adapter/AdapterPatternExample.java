package com.example._0_design_patterns.structural.adapter;

public class AdapterPatternExample {
    public static void main(String[] args) {
        new ModernPrinterAdapter(
                new LegacyPrinter(){
                    @Override
                    public void printDocument() {
                        System.out.println("Printing document");
                    }
                }
        ).print();
    }
}

