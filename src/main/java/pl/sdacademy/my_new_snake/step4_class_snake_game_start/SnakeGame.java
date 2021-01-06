package pl.sdacademy.my_new_snake.step4_class_snake_game_start;

// 1. Tworzę klasę SnakeGame, która opisuje rozgrywkę
// 2. Tworzę metodę start w klasie SnakeGame, która rozpoczyna ruch węża. Tworzę pole typu Snake.
//    Wąż rozpczyna ruch podobny do poprzedniego testu, tylo w odstepach 500 milisekund.
// 3. Tworzę metodę prywatną print w klase SnakeGame, która będzie wypisywać pozycję węża w konsoli.
//    Metodę print stosuję w metodzie start.
// 4. Dla pola typu Snake w SnakeGame implementuję przykładowego węża z głową i ogonem dł 3
// 5. Ekstrachuję metodę snakeSquareMoveTest dla testowego ruchu węża

import java.util.Arrays;

public class SnakeGame {
    private Snake snake = new Snake(new Point(3, 0),
            Arrays.asList(new Point(2, 0), new Point(1, 0), new Point(0, 0)));

    public void start() {
        snakeSquareMoveTest();
    }

    private void snakeSquareMoveTest() {
        System.out.println("start");
        System.out.println("right");
        print();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.move(Direction.RIGHT);
            print();
        }
        System.out.println("down and expand");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.expand(Direction.DOWN);
            print();
        }
        System.out.println("left");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.move(Direction.LEFT);
            print();
        }
        System.out.println("up");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.move(Direction.UP);
            print();
        }
        System.out.println("Koniec ruchu węża");
    }

    private void print() {
        System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
        System.out.print("body=");
        for (int i = 0; i < snake.getBody().size(); i++) {
            System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
        }
        System.out.println();
    }
}
