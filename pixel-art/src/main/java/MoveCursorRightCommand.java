public class MoveCursorRightCommand implements Command {
    private PixelCanvas canvas;
    private DrawingBoard drawingBoard;

    public MoveCursorRightCommand(PixelCanvas canvas, DrawingBoard drawingBoard) {
        this.canvas = canvas;
        this.drawingBoard = drawingBoard;
    }

    public void execute() {
        int prevX = drawingBoard.getX();
        int prevY = drawingBoard.getY();
        drawingBoard.moveCursorRight();
        canvas.drawPixel(prevX, prevY, drawingBoard.isFilled(prevX, prevY), false);
        canvas.drawPixel(drawingBoard.getX(), drawingBoard.getY(), drawingBoard.isFilled(prevX, prevY), true);
    }
}
