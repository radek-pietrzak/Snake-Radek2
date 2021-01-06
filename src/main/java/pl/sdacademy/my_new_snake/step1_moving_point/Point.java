package pl.sdacademy.my_new_snake.step1_moving_point;

//1. Tworzę klasę Point z polami współrzędnych x i y. Tworzę konstruktor.
//3. Dodaję pole typu Direction do klasy Point
//4. Dodaję metodę move do klasy Point, która zwraca nowy punkt z godnie z kierunkiem przemieszczenia.
//5. Tworzę setter setDirection, w klasie Point, do zmiany kierunku ruchu punktu
//6. Tworzę gettery dla x i y w celu sprawdzenia pozycji punktu w konsoli głównej


public class Point {
    private int x;
    private int y;
    private Direction direction;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public Point move(Direction direction) {
        switch (direction) {
            case UP:
                return new Point(x, y - 1);
            case DOWN:
                return new Point(x, y + 1);
            case RIGHT:
                return new Point(x + 1, y);
            case LEFT:
                return new Point(x - 1, y);
            default:
                throw new IllegalArgumentException();
        }
    }


}
