package com.example.atm.service;

import com.example.atm.Card;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    @Getter private final Map<String, Long> accountBalance = new ConcurrentHashMap<>();

    public void addCard(Card card) {
        accountBalance.put(card.getCardNumber(), 0L);
    }

    public void credit(Card card, long amount) {
        accountBalance.put(
                card.getCardNumber(),
                accountBalance.getOrDefault(card.getCardNumber(), 0L) + amount);
    }

    public void debit(Card card, long amount) {
        long balance = accountBalance.get(card.getCardNumber());
        if (balance < amount) {
            System.out.println("Insufficient balance !!");
            return;
        }
        long remaining = balance - amount;
        System.out.println("Amount received:" + amount + ". Balance:" + remaining);
        accountBalance.put(card.getCardNumber(), remaining);
    }
}
