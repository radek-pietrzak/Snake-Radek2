package pl.sdacademy.my_new_snake.step3_snake_expands;

// 3. Testuję metodę expand i move wykorzystują poprzedni test

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
            snake.move(Direction.RIGHT);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }

        System.out.println("down and expand");
        for (int p = 0; p < 5; p++) {
            snake.expand(Direction.DOWN);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }

        System.out.println("left");
        for (int p = 0; p < 5; p++) {
            snake.move(Direction.LEFT);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }

        System.out.println("up");
        for (int p = 0; p < 5; p++) {
            snake.move(Direction.UP);
            System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
            System.out.print("body=");
            for (int i = 0; i < snake.getBody().size(); i++) {
                System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
            }
            System.out.println();
        }
    }
}
