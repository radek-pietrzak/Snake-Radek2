package pl.sdacademy.my_new_snake.step7_snake_game_printer;

// 2. Tworzę implementację interfejsu SnakeGamePrinter - SnakeGameConsolePrinter

public class SnakeGameConsolePrinter implements SnakeGamePrinter {
    @Override
    public void print(String gameBoard) {
        System.out.println(gameBoard);
    }
}
