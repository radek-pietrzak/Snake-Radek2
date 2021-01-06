package pl.sdacademy.my_new_snake.step5_class_snake_game_bounds_apple;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SnakeGame snakeGame = new SnakeGame(new Snake(new Point(3, 0),
                Arrays.asList(new Point(2, 0), new Point(1, 0), new Point(0, 0))),
                10,10);
        snakeGame.start();
    }
}
