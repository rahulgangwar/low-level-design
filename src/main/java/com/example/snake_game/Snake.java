package com.example.snake_game;

import lombok.Getter;

import java.util.ArrayDeque;
import java.util.Deque;

public class Snake {
    @Getter
    private final Deque<Position> body = new ArrayDeque<>();
    @Getter private Direction direction;

    public Snake(Position initialPosition, Direction direction) {
        body.offerFirst(initialPosition);
        this.direction = direction;
    }

    public Position getHead() {
        return body.peekFirst();
    }

    public void changeDirection(Direction direction) {
        if (!this.direction.isOpposite(direction)) {
            this.direction = direction;
        }
    }

    public boolean isPartOfBody(Position position) {
        return body.contains(position);
    }

    public void addToBody(Position position, boolean growTheSnake) {
        body.offerFirst(position);
        if (!growTheSnake) {
            body.pollLast();
        }
    }
}
