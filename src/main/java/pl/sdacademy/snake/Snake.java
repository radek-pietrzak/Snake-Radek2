package pl.sdacademy.snake;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snake {
    private Point head;
    private List<Point> body;
    private Direction direction;

    public Snake(Point head, List<Point> body, Direction direction) {
        this.head = head;
        this.body = new ArrayList<>(body);
        this.direction = direction;
    }

    public Snake() {
        this(new Point(0, 0), Collections.emptyList(), Direction.EAST);
    }

    public Point getHead() {
        return head;
    }

    public void setHead(Point head) {
        this.head = head;
    }

    public List<Point> getBody() {
        return body;
    }

    public void setBody(List<Point> body) {
        this.body = body;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public void expand() {
        body.add(0, head);
        head = head.move(direction);
    }

    public void cutTail() {
        body.add(0, head);
        body.remove(body.size() - 1);
    }


    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", body=" + body +
                ", direction=" + direction +
                '}';
    }
}
