package pl.sdacademy.my_new_snake.step7_snake_game_printer;

// 3. Dodaję pole SnakeGamePrinter o nazwie printer i tworzę dodatkowy konstruktor
// 4. Modyfikuję metodę print2 tak aby zamiast void dawała String


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private Snake snake;
    private int xBound;
    private int yBound;
    private Point apple;
    private SnakeGamePrinter printer;

    public SnakeGame(int xBound, int yBound, Snake snake, SnakeGamePrinter printer) {
        this.xBound = xBound;
        this.yBound = yBound;
        this.snake = snake;
        this.printer = printer;
    }

    public SnakeGame(int xBound, int yBound, SnakeGamePrinter printer) {
        this(xBound, yBound, new Snake(), printer);
    }

    public void start() {
        startSetDirectionUI();
        randomizeApple();
        while (isSnakeInBounds()) {
            print1();
            printer.print(print2());
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ifSnakeEatsApple();
            ifSnakeBitesBody();
        }
        System.out.println("Game over!!");
    }

    private void ifSnakeBitesBody() {
        if (isBodyContainsPoint(snake.getHead())) {
            int index = snake.getBodyPointIndex(snake.getHead());
            System.out.println(index);
            List<Point> newBody = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                newBody.add(snake.getBody().get(i));
            }
            snake = new Snake(snake.getHead(), newBody, snake.getDirection());
        }
    }

    private boolean isSnakeInBounds() {
        return snake.getHead().getX() < xBound
                && snake.getHead().getX() >= 0
                && snake.getHead().getY() < yBound
                && snake.getHead().getY() >= 0;
    }

    private void startSetDirectionUI() {
        Thread thread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                switch (scanner.nextLine()) {
                    case "w":
                        if (snake.getDirection().equals(Direction.DOWN)) {
                            System.out.println("I can't move back!!");
                        } else {
                            snake.setDirection(Direction.UP);
                        }
                        break;
                    case "d":
                        if (snake.getDirection().equals(Direction.LEFT)) {
                            System.out.println("I can't move back!!");
                        } else {
                            snake.setDirection(Direction.RIGHT);
                        }
                        break;
                    case "a":
                        if (snake.getDirection().equals(Direction.RIGHT)) {
                            System.out.println("I can't move back!!");
                        } else {
                            snake.setDirection(Direction.LEFT);
                        }
                        break;
                    case "s":
                        if (snake.getDirection().equals(Direction.UP)) {
                            System.out.println("I can't move back!!");
                        } else {
                            snake.setDirection(Direction.DOWN);
                        }
                        break;
                    default:
                        System.out.println("Niepoprawny kierunke ruchu. Użyj w s a d");
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }


    private void ifSnakeEatsApple() {
        if (isHeadContainsPoint(apple)) {
            snake.expand(snake.getDirection());
            randomizeApple();
        } else {
            snake.move(snake.getDirection());
        }
    }

    private void print1() {
        System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
        System.out.print("body=");
        for (int i = 0; i < snake.getBody().size(); i++) {
            System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
        }
        System.out.println();
    }

    private String print2() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < yBound; y++) {
            for (int x = 0; x < xBound; x++) {
                Point point = new Point(x, y);
                char boardCharacter = getBoardCharacter(point);
                stringBuilder.append(boardCharacter);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    private char getBoardCharacter(Point point) {
        if (isHeadContainsPoint(point)) {
            return 'H';
        } else if (isBodyContainsPoint(point)) {
            return 'B';
        } else if (apple.getX() == point.getX() && apple.getY() == point.getY()) {
            return 'A';
        } else {
            return '.';
        }
    }

    private boolean isHeadContainsPoint(Point point) {
        return point.getX() == snake.getHead().getX() && point.getY() == snake.getHead().getY();
    }

    private boolean isBodyContainsPoint(Point point) {
        for (int i = 0; i < snake.getBody().size(); i++) {
            if (point.getX() == snake.getBody().get(i).getX() && point.getY() == snake.getBody().get(i).getY()) {
                return true;
            }
        }
        return false;
    }

    private void randomizeApple() {
        Random random = new Random();
        int randomX;
        int randomY;
        do {
            randomX = random.nextInt(xBound);
            randomY = random.nextInt(yBound);
            apple = new Point(randomX, randomY);
        }
        while (isHeadContainsPoint(apple) || isBodyContainsPoint(apple));
    }
}
