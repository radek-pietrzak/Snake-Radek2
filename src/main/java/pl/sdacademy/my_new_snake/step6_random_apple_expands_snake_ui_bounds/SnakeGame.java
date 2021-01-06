package pl.sdacademy.my_new_snake.step6_random_apple_expands_snake_ui_bounds;

// 1. Wstawiam w metodę snakeSquareMoveTest możliwość wydłużania węża gdy trafi na jabłko ifSnakeEatsApple,
//    zamiast automatycznego wydłużania przy ruchu w dół
//    oraz modyfikuję metodę tak aby ustawiała inaczej kierunek ruchu
// 2. Modyfikuję metodę randomizeApple, aby jabłko było losowane w granicach planszy
// 3. Modyfikuję metedę ranoomizeApple, aby jabłko nie było losowane na wężu
// 4. Dodaję do metody ifSnakeEatsApple metodę randomizeApple jak tylko wąż się powiększy
// 5. Dodaję do metody start startSetDirectionUI, która umożliwia użytkownikowi zmianę kierunku ruchu węża z konsoli
// 6. Modyfikuję metodę start aby po wypadnięciu z planszy nasępował koniec gry
// 7. Aby wąż odgryzał swój ogon dodaję metodę ifSnakeBitesBody
// 8. Modyfikuję metodę startSetDirectionUI tak aby wąż nie mógł się cofnąć


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {
    private Snake snake;
    private int xBound;
    private int yBound;
    private Point apple;

    public SnakeGame(Snake snake, int xBound, int yBound) {
        this.snake = snake;
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public void start() {
        startSetDirectionUI();
        randomizeApple();
        while (isSnakeInBounds()) {
            print();
            print2();
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

    private void snakeSquareMoveTest() {
        System.out.println("start");
        System.out.println("right");
        print();
        print2();
        snake.setDirection(Direction.RIGHT);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ifSnakeEatsApple();
            print();
            print2();
        }
        snake.setDirection(Direction.DOWN);
        System.out.println("down and expand");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ifSnakeEatsApple();
            print();
            print2();
        }
        snake.setDirection(Direction.LEFT);
        System.out.println("left");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ifSnakeEatsApple();
            print();
            print2();
        }
        System.out.println("up");
        snake.setDirection(Direction.UP);
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ifSnakeEatsApple();
            print();
            print2();
        }
        System.out.println("Koniec ruchu testowego węża");
    }

    private void ifSnakeEatsApple() {
        if (isHeadContainsPoint(apple)) {
            snake.expand(snake.getDirection());
            randomizeApple();
        } else {
            snake.move(snake.getDirection());
        }
    }

    private void print() {
        System.out.print("head=(" + snake.getHead().getX() + "," + snake.getHead().getY() + ") ");
        System.out.print("body=");
        for (int i = 0; i < snake.getBody().size(); i++) {
            System.out.print("(" + snake.getBody().get(i).getX() + "," + snake.getBody().get(i).getY() + ")");
        }
        System.out.println();
    }

    private void print2() {
        for (int y = 0; y < yBound; y++) {
            for (int x = 0; x < xBound; x++) {
                Point point = new Point(x, y);
                System.out.print(getBoardCharacter(point));
            }
            System.out.println();
        }
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
