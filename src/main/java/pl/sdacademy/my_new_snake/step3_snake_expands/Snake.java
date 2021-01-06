package pl.sdacademy.my_new_snake.step3_snake_expands;

// 1. Dodaję metodę expand do klasy Snake, która wydłuża węża
// 2. Zmieniam nazwę metody snakeMove na move w klasie Snake


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
