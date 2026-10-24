package com.example._0_design_patterns.behavioural.state_pattern.state;

import com.example._0_design_patterns.behavioural.state_pattern.enums.Product;
import com.example._0_design_patterns.behavioural.state_pattern.context.VendingMachine;

import java.util.Map;

public class IdleState implements State {

    @Override
    public void selectProduct(VendingMachine context, Product product) {
        // Check Stock
        Map<Product, Integer> productStock = context.getProductStock();
        boolean haveStock = productStock.containsKey(product) && productStock.get(product) > 0;
        if (!haveStock) {
            System.out.println("Item out of stock !!");
            return;
        }

        // If available, Show amount to enter
        double productPrice = context.getPrice(product);
        System.out.println("Add money:" + productPrice);
        context.setSelectedProduct(product);

        // Move to add money state
        context.setState(new AddMoney());
    }

    @Override
    public void addMoney(VendingMachine context, double amount) {
        System.out.println("Select the product first");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        System.out.println("Select the product first");
    }
}
