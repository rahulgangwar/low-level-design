package com.example.snake_game;

import lombok.Getter;

import java.util.Deque;
import java.util.Optional;

public class SnakeGame {
    private final int rows;
    private final int cols;
    @Getter private final Snake snake;
    private final FoodGenerator foodGenerator;
    @Getter private GameStatus status;
    private Position food;
    @Getter
    private int score;

    public SnakeGame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        snake = new Snake(new Position(1, 1), Direction.DOWN);
        foodGenerator = new FoodGenerator(rows, cols);
        status = GameStatus.READY;
        score = 0;
        food = foodGenerator.generate(snake).orElse(null);
    }

    public void start() {
        if (status == GameStatus.READY) {
            status = GameStatus.RUNNING;
        }
    }

    public void changeDirection(Direction direction) {
        if (status == GameStatus.RUNNING) {
            snake.changeDirection(direction);
        }
    }

    public void tick() {
        if (status != GameStatus.RUNNING) return;

        Position nextHead = Util.getNextPosition(snake.getHead(), snake.getDirection());

        // Check for wall collision
        if (!inGameBound(nextHead)) {
            System.out.println("Wall Collision !! Game Over !!");
            status = GameStatus.GAME_OVER;
            return;
        }

        // Check if collision with snake body
        if (snake.isPartOfBody(nextHead)) {
            System.out.println("Wall Collision !! Collision with self !!");
            status = GameStatus.GAME_OVER;
            return;
        }

        boolean growTheSnake = nextHead.equals(food);
        if (growTheSnake) {
            score++;
        }
        snake.addToBody(nextHead, growTheSnake);

        if (growTheSnake) {
            Optional<Position> optionalPosition = foodGenerator.generate(snake);
            if (optionalPosition.isPresent()) {
                food = optionalPosition.get();
            } else {
                status = GameStatus.WON;
            }
        }
    }

    private boolean inGameBound(Position position) {
        int r = position.row();
        int c = position.col();
        return r > 0 && r < rows && c > 0 && c < cols;
    }

    public void printBoard() {
        Deque<Position> body = snake.getBody();

        // Top boundary
        System.out.println("_".repeat(cols + 2));
        for (int row = 0; row < rows; row++) {
            System.out.print("|");

            for (int col = 0; col < cols; col++) {
                Position position = new Position(row, col);

                if (body.contains(position)) {
                    System.out.print("*");
                } else if (position.equals(food)) {
                    System.out.print("+");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }

        // Bottom boundary
        System.out.println("_".repeat(cols + 2));
    }
}
