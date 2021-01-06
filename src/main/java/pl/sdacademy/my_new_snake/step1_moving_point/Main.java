package pl.sdacademy.my_new_snake.step1_moving_point;
//7. Sprawdzam jak działa metoda move, tworząc 4 pętle - każda nadaje inny kierunek.
// Przy każdej iteracji wypisuję pozycję punktu w konsoli

public class Main {
    public static void main(String[] args) {
        Point point = new Point(0, 0);
        System.out.println("move right");
        for (int i = 0; i < 5; i++) {
            point = point.move(Direction.RIGHT);
            System.out.println("x=" + point.getX() + ", y=" + point.getY());
        }
        System.out.println();
        System.out.println("move down");
        for (int i = 0; i < 5; i++) {
            point = point.move(Direction.DOWN);
            System.out.println("x=" + point.getX() + ", y=" + point.getY());
        }
        System.out.println();
        System.out.println("move left");
        for (int i = 0; i < 5; i++) {
            point = point.move(Direction.LEFT);
            System.out.println("x=" + point.getX() + ", y=" + point.getY());
        }
        System.out.println();
        System.out.println("move up");
        for (int i = 0; i < 5; i++) {
            point = point.move(Direction.UP);
            System.out.println("x=" + point.getX() + ", y=" + point.getY());
        }
    }
}
