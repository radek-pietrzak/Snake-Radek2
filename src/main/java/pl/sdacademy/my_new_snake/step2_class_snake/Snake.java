package pl.sdacademy.my_new_snake.step2_class_snake;

// 1. Tworzę klasę Snake, która reprezentuje węża. Dodaję pola head typu Point i body typu lista punktów.
// 2. Tworzę konstruktor węża, którego głowa to punkt, a ciało to new ArrayList
// 3. Torzę metodę move, która symuluje ruch węża (głowy i podążającego za nim ciała)
// 4. Ustawiam gettery dla head i body.Będą pomocne przy sprawdzaniu poprawności metody.

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Point head;
    private List<Point> body;

    public Snake(Point head, List<Point> body) {
        this.head = head;
        this.body = new ArrayList<>(body);
    }

    public void snakeMove(Direction direction) {
        body.add(0,head);
        body.remove(body.size() - 1);
        head = head.move(direction);
    }

    public Point getHead() {
        return head;
    }

    public List<Point> getBody() {
        return body;
    }


}
