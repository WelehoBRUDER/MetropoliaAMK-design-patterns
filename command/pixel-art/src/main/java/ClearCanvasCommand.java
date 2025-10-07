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
        int cursorX = drawingBoard.getX();
        int cursorY = drawingBoard.getY();
        int[][] board = drawingBoard.getBoard();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                canvas.drawPixel(x, y, board[y][x] == 1, drawingBoard.isSelected(x, y));
            }
        }
        canvas.drawPixel(cursorX, cursorY, false, true);
    }
}
