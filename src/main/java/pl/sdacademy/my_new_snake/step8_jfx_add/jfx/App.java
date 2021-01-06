package pl.sdacademy.my_new_snake.step8_jfx_add.jfx;

// 1. Kopiuję klasy App i SystemInfo oraz zmieniam w module-info.java informację export gdzie zamiściłem te klasy
//    aby aplikacja właściwie działała
// 2. Ustawiam scenę, płótno i przyciski
// 4. Tworzę fragment kodu ustawiający graficznie granice planszy oraz wielkość punktu
// 7. Dodaję akcje do przycisków


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import pl.sdacademy.my_new_snake.step8_jfx_add.Direction;
import pl.sdacademy.my_new_snake.step8_jfx_add.Snake;
import pl.sdacademy.my_new_snake.step8_jfx_add.SnakeGame;
import pl.sdacademy.my_new_snake.step8_jfx_add.SnakeGameJavaFxPrinter;


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

        buttonLeft.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.LEFT));
        buttonRight.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.RIGHT));
        buttonUp.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.UP));
        buttonDown.setOnAction(actionEvent -> snakeGame.setSnakeDirection(Direction.DOWN));
    }

    public static void main(String[] args) {
        launch();
    }

}