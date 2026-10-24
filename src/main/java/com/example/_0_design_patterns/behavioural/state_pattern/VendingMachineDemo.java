package com.example._0_design_patterns.behavioural.state_pattern;

import com.example._0_design_patterns.behavioural.state_pattern.context.VendingMachine;
import com.example._0_design_patterns.behavioural.state_pattern.enums.Product;

public class VendingMachineDemo {
    public static void main(String[] args){
        VendingMachine machine = new VendingMachine();
        machine.selectProduct(Product.CHIPS);
        machine.addMoney(5);
        machine.addMoney(5);
        machine.dispenseProduct();
    }
}
