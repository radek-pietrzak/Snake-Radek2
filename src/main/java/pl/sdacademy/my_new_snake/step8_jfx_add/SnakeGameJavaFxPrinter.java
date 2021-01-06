package pl.sdacademy.my_new_snake.step8_jfx_add;

// 3. Tworzę metodę drawPoint, która będzie rysowała punkt o zadanych rozmiarach
// 5. Modyfikuję metodę print aby rysowała węża
// 6. Tworzę metodę getColorForBoardCharacter, która na podstawie wypisywanych liter w konsoli daje informacji co rysować

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class SnakeGameJavaFxPrinter implements SnakeGamePrinter {
    GraphicsContext graphicsContext;
    int pointSize;

    public SnakeGameJavaFxPrinter(GraphicsContext graphicsContext, int pointSize) {
        this.graphicsContext = graphicsContext;
        this.pointSize = pointSize;
    }

    private void drawPoint(int x, int y, Color color) {
        graphicsContext.setFill(color);
        graphicsContext.fillRect(x * pointSize, y * pointSize, pointSize, pointSize);
    }

    @Override
    public void print(String gameBoard) {
        System.out.println(gameBoard);
        int x = 0;
        int y = 0;
        for (int i = 0; i < gameBoard.length(); i++) {
            char boardCharacter = gameBoard.charAt(i);
            if (boardCharacter == '\n') {
                y++;
                x = 0;
                continue;
            }
            Color color = getColorForBoardCharacter(boardCharacter);
            drawPoint(x, y, color);
            x++;
        }
    }

    private Color getColorForBoardCharacter(char character) {
        switch (character) {
            case '.':
                return Color.GREENYELLOW;
            case 'H':
                return Color.BROWN;
            case 'B':
                return Color.SANDYBROWN;
            case 'A':
                return Color.RED;
            default:
                throw new IllegalArgumentException("Błędny znak planszy gry");
        }
    }
}
