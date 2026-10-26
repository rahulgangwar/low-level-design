package com.example.snake_game;

public enum Direction {
    UP(1),
    DOWN(-1),
    LEFT(2),
    RIGHT(-2);
    final int val;

    Direction(int val) {
        this.val = val;
    }

    public boolean isOpposite(Direction direction) {
        return this.val == (direction.val * -1);
    }
}
