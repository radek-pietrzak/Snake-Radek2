package pl.sdacademy.snake;

import java.util.Random;

public class SnakeGame {
    private int xBound;
    private int yBound;
    private Snake snake;
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
        randomizeApple();
        while (isSnakeInBounds()) {
            printer.print(toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.expand();
            if (apple.equals(snake.getHead())) {
                randomizeApple();
            } else {
                snake.cutTail();
            }
        }
        System.out.println("Snake out of bounds");
        System.out.println("Game over!");
    }


    private boolean isSnakeInBounds() {
        return snake.getHead().getX() < xBound || snake.getHead().getY() < yBound;
    }

    public void randomizeApple() {
        Random random = new Random();
        do {
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
            apple = new Point(appleX, appleY);
        }
        while (isAppleOnSnake(apple));


    }

    private boolean isAppleOnSnake(Point point) {
        return snake.getHead().equals(point) || snake.getBody().contains(point);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < yBound; y++) {
            for (int x = 0; x < xBound; x++) {
                Point point = new Point(x, y);
                char boardCharacter = getBoardCharacterAt(point);
                stringBuilder.append(boardCharacter);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private char getBoardCharacterAt(Point point) {
        if (point.equals(apple)) {
            return 'A';
        } else if (point.equals(snake.getHead())) {
            return 'H';
        } else if (snake.getBody().contains(point)) {
            return 'B';
        } else {
            return '.';
        }
    }

    public void setSnakeDirection(Direction direction) {
        snake.setDirection(direction);
    }
}
