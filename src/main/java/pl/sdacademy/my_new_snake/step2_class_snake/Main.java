package pl.sdacademy.my_new_snake.step2_class_snake;

// 5. Tworzę przykładowego węża, z głową i ogonem długości 3
// 6. Testuję metodę move wywołując ją w petlach i przemieszczajęc węża po kwadracie
//    w czterech różnych kierukach wypisując w konsoli punkty głowy i ciała. Sprawdzam poprawność pozycji głowy i ciała.

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Snake snake = new Snake(new Point(3, 0),
                Arrays.asList(new Point(2, 0), new Point(1, 0), new Point(0, 0)));

        System.out.println("start");
        System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
        System.out.print("body=");
        for (int i = 0; i < snake.getBody().size(); i++) {
            System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
        }
        System.out.println();

        System.out.println("right");
        for (int p = 0; p < 5; p++) {
            snake.snakeMove(Direction.RIGHT);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }

        System.out.println("down");
        for (int p = 0; p < 5; p++) {
            snake.snakeMove(Direction.DOWN);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }

        System.out.println("left");
        for (int p = 0; p < 5; p++) {
            snake.snakeMove(Direction.LEFT);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }

        System.out.println("up");
        for (int p = 0; p < 5; p++) {
            snake.snakeMove(Direction.UP);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }
    }
}
