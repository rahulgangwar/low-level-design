package com.example.atm.state;

import com.example.atm.Card;
import com.example.atm.context.ATM;

public class CardInsertedState extends AbstractATMState {

    public CardInsertedState(ATM atm) {
        super(atm);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        // todo verify pin using authentication service
        // for now we are logging pin and marking authenticated by default

        System.out.println("PIN is authenticated");
        atm.setState(new AuthenticatedState(atm));
    }

    @Override
    public void checkBalance() {
        System.out.println("Enter the PIN");
    }

    @Override
    public void withdraw(long amount) {
        System.out.println("Enter the PIN");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atm.setState(new IdleState(atm));
    }
}
