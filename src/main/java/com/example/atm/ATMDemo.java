package com.example.atm;

import com.example.atm.context.ATM;
import com.example.atm.service.BankService;

public class ATMDemo {
    public static void main(String[] args) {
        Card card = new Card("1234");

        BankService bankService = new BankService();
        bankService.addCard(card);
        bankService.credit(card, 1000);

        ATM atm = new ATM(bankService);
        atm.insertCard(card);
        atm.enterPin("1234");
        atm.checkBalance();
        atm.withdraw(100);
        atm.ejectCard();
    }
}
