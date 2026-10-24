package com.example.tic_tack_toe;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Player {
    private final String name;
    private final char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
}
