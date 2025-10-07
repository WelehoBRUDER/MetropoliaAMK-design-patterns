public class ClearCanvasCommand implements Command {
    private DrawingBoard drawingBoard;
    private PixelCanvas canvas;

    public ClearCanvasCommand(PixelCanvas canvas, DrawingBoard drawingBoard) {
        this.drawingBoard = drawingBoard;
        this.canvas = canvas;
    }

    @Override
    public void execute() {
        drawingBoard.clear();
        canvas.clearCanvas();
        int x = drawingBoard.getX();
        int y = drawingBoard.getY();
        canvas.drawPixel(x, y, false, true);
    }
}
