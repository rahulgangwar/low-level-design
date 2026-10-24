package com.example.atm.state;

import com.example.atm.Card;

public interface ATMState {
    void insertCard(Card card);
    void enterPin(String pin);
    void checkBalance();
    void withdraw(long amount);
    void ejectCard();
}
