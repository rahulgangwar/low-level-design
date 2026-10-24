package com.example._0_design_patterns.behavioural.state_pattern.state;

import com.example._0_design_patterns.behavioural.state_pattern.enums.Product;
import com.example._0_design_patterns.behavioural.state_pattern.context.VendingMachine;

public class AddMoney implements State {

    @Override
    public void selectProduct(VendingMachine context, Product product) {
        System.out.println(
                "Product is already selected. You need to add money:"
                        + context.getPrice(context.getSelectedProduct()));
    }

    @Override
    public void addMoney(VendingMachine context, double amount) {
        double requiredAmount = context.getPrice(context.getSelectedProduct());
        if (requiredAmount - context.getAmount() - amount > 0) {
            System.out.println("Add more money: " + (requiredAmount - amount));
            context.setAmount(context.getAmount() + amount);
        } else {
            context.setAmount(amount);
            context.setState(new DispenseProduct());
            System.out.println("Ready to dispense product");
        }
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Add money first: " + context.getAmount());
    }
}
