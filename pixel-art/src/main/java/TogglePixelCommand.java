public class TogglePixelCommand implements Command {
    private DrawingBoard drawingBoard;
    private PixelCanvas canvas;

    public TogglePixelCommand(PixelCanvas canvas, DrawingBoard drawingBoard) {
        this.drawingBoard = drawingBoard;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        drawingBoard.toggle();
        int x = drawingBoard.getX();
        int y = drawingBoard.getY();
        canvas.drawPixel(x, y, drawingBoard.isFilled(x, y), drawingBoard.isSelected(x, y));
    }
}
