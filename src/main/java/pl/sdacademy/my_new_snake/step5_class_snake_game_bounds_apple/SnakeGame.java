package pl.sdacademy.my_new_snake.step5_class_snake_game_bounds_apple;

// 1. Do klasy SnakeGame wprowadzam pola Bounds do określenia granic planszy
// 2. Stworzenie metody print2, która tworzy planszę z kropek. Wpisuję ją w snakeSquareMoveTest.
//    Tworzę też kostruktor SnakeGame, który przyjmuje węża i granice planszy. Ustawiam wstępnie granice na 10
//    i przenoszę implementację węża do implementacji SnakeGame w aplikacji.
// 3. Dodaję polę apple i tworzę metodę randomizeApple(), na razie będzie ustawiała jbłko
//    w stałym miejscu gdzie wąż testowy przechodzi. Wstawiam metodę do metody start.
// 4. Usuwam z testowego ruchu węża metodę expand.
// 5. Dodaję do metody getBoarCharacter jabłko wcelu jego wyświętlenia na planszy

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
        randomizeApple();
        snakeSquareMoveTest();
    }

    private void snakeSquareMoveTest() {
        System.out.println("start");
        System.out.println("right");
        print();
        print2();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.move(Direction.RIGHT);
            print();
            print2();
        }
        System.out.println("down and expand");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.move(Direction.DOWN);
            print();
            print2();
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
            print2();
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
            print2();
        }
        System.out.println("Koniec ruchu testowego węża");
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
        apple = new Point(8, 2);
    }
}
