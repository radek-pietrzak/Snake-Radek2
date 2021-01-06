package pl.sdacademy.snake.console;

import pl.sdacademy.snake.Direction;
import pl.sdacademy.snake.SnakeGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        SnakeGame snakeGame = new SnakeGame(10, 10, new SnakeGameConsolePrinter());
        Thread uiThread = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            while (true) {
                switch (scanner.nextLine()) {
                    case "w":
                        snakeGame.setSnakeDirection(Direction.NORTH);
                        break;
                    case "s":
                        snakeGame.setSnakeDirection(Direction.SOUTH);
                        break;
                    case "d":
                        snakeGame.setSnakeDirection(Direction.EAST);
                        break;
                    case "a":
                        snakeGame.setSnakeDirection(Direction.WEST);
                        break;
                    default:
                        System.out.println("Niepoprawny kierunek ruchu (w, s, d, a)");
                }
            }
        });
        uiThread.setDaemon(true);
        uiThread.start();
        snakeGame.start();
    }
}
