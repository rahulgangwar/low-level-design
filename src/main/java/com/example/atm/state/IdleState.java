package com.example.atm.state;

import com.example.atm.Card;
import com.example.atm.context.ATM;

public class IdleState extends AbstractATMState {

    public IdleState(ATM atm) {
        super(atm);
    }

    @Override
    public void insertCard(Card card) {
        if (card == null) {
            System.out.println("Invalid card");
            return;
        }

        atm.setCurrentCard(card);
        atm.setState(new CardInsertedState(atm));
        System.out.println("Card inserted. Please enter PIN.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("Insert card first.");
    }

    @Override
    public void checkBalance() {
        System.out.println("Insert card first.");
    }

    @Override
    public void withdraw(long amount) {
        System.out.println("Insert card first.");
    }

    @Override
    public void ejectCard() {
        System.out.println("Insert card first.");
    }
}
