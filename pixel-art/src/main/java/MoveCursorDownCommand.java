public class MoveCursorDownCommand implements Command {
    private PixelCanvas canvas;
    private DrawingBoard drawingBoard;
    private MovementCommand movementCommand;

    public MoveCursorDownCommand(PixelCanvas canvas, DrawingBoard drawingBoard) {
        this.canvas = canvas;
        this.drawingBoard = drawingBoard;
        this.movementCommand = new MovementCommand(this.drawingBoard, this.canvas);
    }

    public void execute() {
        this.movementCommand.move(Direction.DOWN);
    }
}
