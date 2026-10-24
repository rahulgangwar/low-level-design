package com.example._0_design_patterns.behavioural.state_pattern.state;

import com.example._0_design_patterns.behavioural.state_pattern.enums.Product;
import com.example._0_design_patterns.behavioural.state_pattern.context.VendingMachine;

public interface State {
    public void selectProduct(VendingMachine context, Product product);
    public void addMoney(VendingMachine context, double amount);
    public void dispenseProduct(VendingMachine context);
}
