public class MoveCursorDownCommand implements Command {
    private PixelCanvas canvas;
    private DrawingBoard drawingBoard;

    public MoveCursorDownCommand(PixelCanvas canvas, DrawingBoard drawingBoard) {
        this.canvas = canvas;
        this.drawingBoard = drawingBoard;
    }

    public void execute() {
        int prevX = drawingBoard.getX();
        int prevY = drawingBoard.getY();
        drawingBoard.moveCursorDown();
        int currX = drawingBoard.getX();
        int currY = drawingBoard.getY();
        canvas.drawPixel(prevX, prevY, drawingBoard.isFilled(prevX, prevY), false);
        canvas.drawPixel(currX, currY, drawingBoard.isFilled(currX, currY), true);
    }
}
