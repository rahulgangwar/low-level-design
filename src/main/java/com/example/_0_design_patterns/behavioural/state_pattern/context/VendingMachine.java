package com.example._0_design_patterns.behavioural.state_pattern.context;

import com.example._0_design_patterns.behavioural.state_pattern.enums.Product;
import com.example._0_design_patterns.behavioural.state_pattern.state.IdleState;
import com.example._0_design_patterns.behavioural.state_pattern.state.State;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Workflow:
 * 1. Machine is idle
 * 2. Select the product you want. Machine will show you the money to insert.
 * 3. Insert the coin for the specified amount.
 * 4. Machine will dispense the product and will get back to Idle state.
 */
@Data
public class VendingMachine {
    private State state;
    private double amount;
    private Product selectedProduct;
    private final Map<Product, Integer> productPrice = new HashMap<>();
    private final Map<Product, Integer> productStock = new ConcurrentHashMap<>();

    public VendingMachine(){
        state = new IdleState();

        productPrice.put(Product.COKE , 20);
        productPrice.put(Product.CHIPS , 10);
        productPrice.put(Product.CHOCHLATE , 20);

        productStock.put(Product.COKE , 5);
        productStock.put(Product.CHIPS , 5);
        productStock.put(Product.CHOCHLATE , 5);
    }

    public void selectProduct(Product product) {
        state.selectProduct(this, product);
    }

    public void addMoney(double amount) {
        state.addMoney(this, amount);
    }

    public void dispenseProduct() {
        state.dispenseProduct(this);
    }

    public double getPrice(Product product){
        return productPrice.get(product);
    }
}
