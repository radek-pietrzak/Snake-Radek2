package pl.sdacademy.my_new_snake.step8_jfx_add;

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

    public void setDirection(Direction direction){
        this.direction = direction;
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
