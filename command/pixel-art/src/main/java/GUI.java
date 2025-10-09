import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox controlLayout = new VBox(10);
        Scene controlScene = new Scene(controlLayout);
        Stage controlStage = new Stage();

        DrawingBoard drawingBoard = new DrawingBoard(12, 10);
        int[][] board = drawingBoard.getBoard();
        PixelCanvas pixelCanvas = new PixelCanvas(board[0].length, board.length);

        Controls controls = getControls(pixelCanvas, drawingBoard);
        ControlPanel controlPanel = new ControlPanel(controls, pixelCanvas);

        controlLayout.getChildren().addAll(controlPanel.getHBox(), pixelCanvas.getCanvas());
        controlScene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case RIGHT -> controls.moveCursorRight();
                case LEFT -> controls.moveCursorLeft();
                case UP -> controls.moveCursorUp();
                case DOWN -> controls.moveCursorDown();
                case SPACE -> controls.togglePixel();
                case ENTER -> controls.generateCode();
            }
        });
        pixelCanvas.getCanvas().requestFocus();


        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                pixelCanvas.drawPixel(x, y, board[y][x] == 1, drawingBoard.isSelected(x, y));
            }
        }

        controlStage.setTitle("Pixel Art Editor");
        controlStage.setScene(controlScene);
        controlStage.show();
    }

    private Controls getControls(PixelCanvas pixelCanvas, DrawingBoard drawingBoard) {
        Command moveCursorRightCommand = new MoveCursorRightCommand(pixelCanvas, drawingBoard);
        Command moveCursorLeftCommand = new MoveCursorLeftCommand(pixelCanvas, drawingBoard);
        Command moveCursorUpCommand = new MoveCursorUpCommand(pixelCanvas, drawingBoard);
        Command moveCursorDownCommand = new MoveCursorDownCommand(pixelCanvas, drawingBoard);
        Command togglePixelCommand = new TogglePixelCommand(pixelCanvas, drawingBoard);
        Command generateCodeCommand = new GenerateCodeCommand(drawingBoard);
        Command clearCanvasCommand = new ClearCanvasCommand(pixelCanvas, drawingBoard);

        return new Controls(moveCursorLeftCommand, moveCursorRightCommand, moveCursorUpCommand, moveCursorDownCommand, togglePixelCommand, generateCodeCommand, clearCanvasCommand);
    }
}
