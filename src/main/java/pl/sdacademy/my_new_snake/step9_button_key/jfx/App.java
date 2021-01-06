package pl.sdacademy.my_new_snake.step9_button_key.jfx;

// 1. Przypisuję zmianę kierunku ruchu węża do klawiszy WSAD
// 2. Poprawiam aby wąż się nie cofał


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdacademy.my_new_snake.step9_button_key.Direction;
import pl.sdacademy.my_new_snake.step9_button_key.SnakeGame;
import pl.sdacademy.my_new_snake.step9_button_key.SnakeGameJavaFxPrinter;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox vBox = new VBox();
        Canvas canvas = new Canvas(200, 200);
        vBox.getChildren().add(canvas);
        HBox hBox = new HBox();
        Button buttonLeft = new Button("left");
        Button buttonUp = new Button("up");
        Button buttonDown = new Button("down");
        Button buttonRight = new Button("right");

        hBox.getChildren().add(buttonLeft);
        hBox.getChildren().add(buttonUp);
        hBox.getChildren().add(buttonDown);
        hBox.getChildren().add(buttonRight);
        vBox.getChildren().add(hBox);


        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();

        // fragment kodu określający graficznie wielkość planszy w canvas i wielkość punktu
        int pointSize = 10;
        int xBound = (int) canvas.getWidth() / pointSize;
        int yBound = (int) canvas.getHeight() / pointSize;
        SnakeGameJavaFxPrinter printer = new SnakeGameJavaFxPrinter(
                canvas.getGraphicsContext2D(),
                pointSize);
        SnakeGame snakeGame = new SnakeGame(xBound, yBound, printer);
        Thread gameThread = new Thread(snakeGame::start);
        gameThread.setDaemon(true);
        gameThread.start();

        // dodanie funkcjonalności do przycisków okna
        buttonLeft.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.LEFT));
        buttonRight.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.RIGHT));
        buttonUp.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.UP));
        buttonDown.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.DOWN));


        // przypisanie ruchów węża do klawiszy
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if (KeyCode.S.equals(key.getCode())) {
                if (!Direction.UP.equals(snakeGame.getSnakeDirection())) {
                    snakeGame.setSnakeDirection(Direction.DOWN);
                }
            } else if (KeyCode.W.equals(key.getCode())) {
                if (!Direction.DOWN.equals(snakeGame.getSnakeDirection())) {
                    snakeGame.setSnakeDirection(Direction.UP);
                }
            } else if (KeyCode.A.equals(key.getCode())) {
                if (!Direction.RIGHT.equals(snakeGame.getSnakeDirection())) {
                    snakeGame.setSnakeDirection(Direction.LEFT);
                }
            } else if (KeyCode.D.equals(key.getCode())) {
                if (!Direction.LEFT.equals(snakeGame.getSnakeDirection())) {
                    snakeGame.setSnakeDirection(Direction.RIGHT);
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }

}