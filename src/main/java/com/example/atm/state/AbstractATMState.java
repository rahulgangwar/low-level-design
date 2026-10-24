package com.example.atm.state;

import com.example.atm.Card;
import com.example.atm.context.ATM;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractATMState implements ATMState {
    protected ATM atm;
}
