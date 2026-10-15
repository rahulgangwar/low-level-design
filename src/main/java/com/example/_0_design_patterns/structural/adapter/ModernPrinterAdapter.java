package com.example._0_design_patterns.structural.adapter;

class ModernPrinterAdapter implements ModernPrinter {

    private final LegacyPrinter legacyPrinter;

    public ModernPrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print() {
        legacyPrinter.printDocument();
    }
}
