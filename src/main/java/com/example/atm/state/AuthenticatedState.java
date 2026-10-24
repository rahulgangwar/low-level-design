package com.example.atm.state;

import com.example.atm.Card;
import com.example.atm.context.ATM;

public class AuthenticatedState extends AbstractATMState {
    public AuthenticatedState(ATM atm) {
        super(atm);
    }

    @Override
    public void insertCard(Card card) {
        System.out.println("A card is already inserted.");
    }

    @Override
    public void enterPin(String pin) {
        System.out.println("PIN is already entered");
    }

    @Override
    public void checkBalance() {
        long balance =
                atm.getBankService()
                        .getAccountBalance()
                        .get(atm.getCurrentCard().getCardNumber());
        System.out.println("Balance: " + balance);
    }

    @Override
    public void withdraw(long amount) {
        System.out.println("Trying to debit: " + amount);
        atm.getBankService().debit(atm.getCurrentCard(), amount);
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atm.setState(new IdleState(atm));
    }
}
