public class MovementCommand {
    private DrawingBoard drawingBoard;
    private PixelCanvas canvas;

    public MovementCommand(DrawingBoard drawingBoard, PixelCanvas canvas) {
        this.drawingBoard = drawingBoard;
        this.canvas = canvas;
    }

    public void move(Direction direction) {
        int prevX = drawingBoard.getX();
        int prevY = drawingBoard.getY();
        switch (direction) {
            case UP -> drawingBoard.moveCursorUp();
            case DOWN -> drawingBoard.moveCursorDown();
            case LEFT -> drawingBoard.moveCursorLeft();
            case RIGHT -> drawingBoard.moveCursorRight();
        }
        int currX = drawingBoard.getX();
        int currY = drawingBoard.getY();
        canvas.drawPixel(prevX, prevY, drawingBoard.isFilled(prevX, prevY), false);
        canvas.drawPixel(currX, currY, drawingBoard.isFilled(currX, currY), true);
    }

}
