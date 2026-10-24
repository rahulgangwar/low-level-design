package com.example._0_design_patterns.behavioural.state_pattern.state;

import com.example._0_design_patterns.behavioural.state_pattern.enums.Product;
import com.example._0_design_patterns.behavioural.state_pattern.context.VendingMachine;

import java.util.Map;

public class DispenseProduct implements State {

    @Override
    public void selectProduct(VendingMachine context, Product product) {
        System.out.println("Product is already selected");
    }

    @Override
    public void addMoney(VendingMachine context, double amount) {
        System.out.println("Required amount is already provided");
    }

    @Override
    public void dispenseProduct(VendingMachine context) {
        Product product = context.getSelectedProduct();
        Map<Product, Integer> productStock = context.getProductStock();
        int qty = productStock.get(product);
        int newQty = (qty == 1) ? 0 : qty - 1;
        productStock.put(product, newQty);
        context.setAmount(0);
        System.out.println(
                "Product dispensed: " + context.getSelectedProduct() + ". Stock left: " + newQty);
        context.setSelectedProduct(null);
    }
}
