package com.example.snake_game;

public class Util {

    public static Position getNextPosition(Position position, Direction direction) {
        if (direction == null) throw new RuntimeException("Invalid direction");
        Position newPosition = null;
        switch (direction) {
            case UP -> newPosition = new Position(position.row() - 1, position.col());
            case DOWN -> newPosition = new Position(position.row() + 1, position.col());
            case RIGHT -> newPosition = new Position(position.row(), position.col() + 1);
            case LEFT -> newPosition = new Position(position.row(), position.col() - 1);
        }
        return newPosition;
    }
}
