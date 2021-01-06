package pl.sdacademy.my_new_snake.step8_jfx_add;


public class Main {
    public static void main(String[] args) {
        SnakeGamePrinter snakeGamePrinter = new SnakeGameConsolePrinter();
        SnakeGame snakeGame = new SnakeGame(10, 10, snakeGamePrinter);
        snakeGame.start();
    }
}
