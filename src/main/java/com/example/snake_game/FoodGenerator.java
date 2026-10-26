package com.example.snake_game;

import java.util.*;

public class FoodGenerator {
    private final int rows;
    private final int cols;
    private final Random random = new Random();

    public FoodGenerator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public Optional<Position> generate(Snake snake) {
        List<Position> availablePositions = new ArrayList<>();

        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                Position position = new Position(r, c);
                if (!snake.isPartOfBody(position)) {
                    availablePositions.add(position);
                }
            }
        }

        int index = random.nextInt(0, availablePositions.size());
        return Optional.ofNullable(availablePositions.get(index));
    }
}
