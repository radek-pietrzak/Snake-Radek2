package pl.sdacademy.snake.console;

import pl.sdacademy.snake.SnakeGamePrinter;

public class SnakeGameConsolePrinter implements SnakeGamePrinter {
    @Override
    public void print(String gameBoard) {
        System.out.println(gameBoard);
    }
}
