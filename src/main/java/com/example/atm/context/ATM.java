package com.example.atm.context;

import com.example.atm.Card;
import com.example.atm.service.BankService;
import com.example.atm.state.ATMState;
import com.example.atm.state.IdleState;

import lombok.Getter;
import lombok.Setter;

/**
 * Workflow
 * =========
 * 1. Insert card
 * 2. Enter PIN
 * 3. Check balance
 * 4. Withdraw money
 * 5. Eject card
 */
public class ATM {
    @Setter private ATMState state;
    @Getter @Setter private Card currentCard;
    @Getter private final BankService bankService;

    public ATM(BankService bankService) {
        this.bankService = bankService;
        this.state = new IdleState(this);
    }

    public void insertCard(Card card) {
        state.insertCard(card);
    }

    public void enterPin(String pin) {
        state.enterPin(pin);
    }

    public void checkBalance() {
        state.checkBalance();
    }

    public void withdraw(long amount) {
        state.withdraw(amount);
    }

    public void ejectCard() {
        state.ejectCard();
    }
}
