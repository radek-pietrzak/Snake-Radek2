package pl.sdacademy.my_new_snake.step9_button_key;


public class Main {
    public static void main(String[] args) {
        SnakeGamePrinter snakeGamePrinter = new SnakeGameConsolePrinter();
        SnakeGame snakeGame = new SnakeGame(10, 10, snakeGamePrinter);
        snakeGame.start();
    }
}
