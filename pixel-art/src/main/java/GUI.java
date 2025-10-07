import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Toggle;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox controlLayout = new VBox(10);
        Scene controlScene = new Scene(controlLayout);
        Stage controlStage = new Stage();

        DrawingBoard drawingBoard = new DrawingBoard(8, 8);
        int[][] board = drawingBoard.getBoard();
        PixelCanvas pixelCanvas = new PixelCanvas(board[0].length, board.length);
        controlLayout.getChildren().add(pixelCanvas.getCanvas());

        Command moveCursorRightCommand = new MoveCursorRightCommand(pixelCanvas, drawingBoard);
        Command moveCursorLeftCommand = new MoveCursorLeftCommand(pixelCanvas, drawingBoard);
        Command moveCursorUpCommand = new MoveCursorUpCommand(pixelCanvas, drawingBoard);
        Command moveCursorDownCommand = new MoveCursorDownCommand(pixelCanvas, drawingBoard);
        Command togglePixelCommand = new TogglePixelCommand(pixelCanvas, drawingBoard);
        Command generateCodeCommand = new GenerateCodeCommand(drawingBoard);

        controlScene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT -> moveCursorRightCommand.execute();
                case LEFT -> moveCursorLeftCommand.execute();
                case UP -> moveCursorUpCommand.execute();
                case DOWN -> moveCursorDownCommand.execute();
                case SPACE -> togglePixelCommand.execute();
                case ENTER -> generateCodeCommand.execute();
            }
        });


        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                pixelCanvas.drawPixel(x, y, board[y][x] == 1, drawingBoard.isSelected(x, y));
            }
        }

        controlStage.setTitle("Control Panel");
        controlStage.setScene(controlScene);
        controlStage.show();
    }
}
