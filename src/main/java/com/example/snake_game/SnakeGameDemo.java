package com.example.snake_game;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class SnakeGameDemo {
    public static void main(String[] args) throws InterruptedException {
        SnakeGame game = new SnakeGame(20, 20);
        BlockingQueue<Direction> inputs = new LinkedBlockingQueue<>();
        game.start();

        // Thread 1: Read keyboard commands.
        Thread inputThread =
                new Thread(
                        () -> {
                            try (Scanner scanner = new Scanner(System.in)) {
                                while (scanner.hasNextLine()) {
                                    String input = scanner.nextLine().trim().toUpperCase();
                                    System.out.println("Received input: [" + input + "]");
                                    switch (input) {
                                        case "W" -> inputs.offer(Direction.UP);
                                        case "A" -> inputs.offer(Direction.LEFT);
                                        case "S" -> inputs.offer(Direction.DOWN);
                                        case "D" -> inputs.offer(Direction.RIGHT);
                                        case "Q" -> {
                                            return;
                                        }
                                        default -> System.out.println("Use W/A/S/D or Q.");
                                    }
                                }
                            }
                        });

        inputThread.setDaemon(true);
        inputThread.start();


        // Thread 2: Move the snake automatically.
        var scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(
                () -> {
                    game.tick();
                    game.printBoard();

                    System.out.println(
                            "Score: "
                                    + game.getScore()
                                    + " | Status: "
                                    + game.getStatus()
                                    + " | Direction: "
                                    + game.getSnake().getDirection()
                                    + " Input size: "
                                    + inputs.size());

                    Direction direction;
                    // Apply queued direction changes
                    while ((direction = inputs.poll()) != null) {
                        System.out.println("Changing direction: " + direction);
                        game.changeDirection(direction);
                    }

                    if (game.getStatus() != GameStatus.RUNNING) {
                        scheduler.shutdown();
                    }
                },
                0,
                500,
                TimeUnit.MILLISECONDS);
        inputThread.join();
    }
}
