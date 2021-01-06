package pl.sdacademy.snake;

public class Point {
    private int x;
    private int y;


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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point move(Direction direction) {
        switch (direction) {
            case NORTH:
                return new Point(x, y - 1);
            case SOUTH:
                return new Point(x, y + 1);
            case EAST:
                return new Point(x + 1, y);
            case WEST:
                return new Point(x - 1, y);
            default:
                throw new IllegalArgumentException();
        }
    }
}
