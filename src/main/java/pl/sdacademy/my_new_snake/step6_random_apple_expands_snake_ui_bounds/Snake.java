package pl.sdacademy.my_new_snake.step6_random_apple_expands_snake_ui_bounds;

import java.util.ArrayList;
import java.util.Arrays;
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
        this(new Point(0,0), Collections.emptyList(),Direction.RIGHT);
    }

//        public Snake() {
//        this(new Point(0,0), Arrays.asList(
//                new Point(-1,0),
//                new Point(-2,0),
//                new Point(-3,0),
//                new Point(-4,0),
//                new Point(-5,0),
//                new Point(-6,0)
//        ),Direction.RIGHT);
//    }

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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setBody(List<Point> body) {
        this.body = body;
    }

    public int getBodyPointIndex(Point point){
        for(int i =0 ; i<body.size(); i++){
            if(body.get(i).getX()==point.getX() && body.get(i).getY()==point.getY()){
                return i;
            }
        }
        return -1;
    }
}
