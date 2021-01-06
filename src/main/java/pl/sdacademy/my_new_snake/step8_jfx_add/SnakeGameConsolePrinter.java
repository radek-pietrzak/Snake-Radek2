package pl.sdacademy.my_new_snake.step8_jfx_add;


public class SnakeGameConsolePrinter implements SnakeGamePrinter {
    @Override
    public void print(String gameBoard) {
        System.out.println(gameBoard);
    }
}
