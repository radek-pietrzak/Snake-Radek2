package pl.sdacademy.my_new_snake.step4_class_snake_game_start;


import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Point head;
    private List<Point> body;

    public Snake(Point head, List<Point> body) {
        this.head = head;
        this.body = new ArrayList<>(body);
    }

    public void move(Direction direction) {
        body.add(0,head);
        body.remove(body.size() - 1);
        head = head.move(direction);
    }

    public void expand(Direction direction) {
        body.add(0,head);
        head = head.move(direction);
    }



    public Point getHead() {
        return head;
    }

    public List<Point> getBody() {
        return body;
    }


}
