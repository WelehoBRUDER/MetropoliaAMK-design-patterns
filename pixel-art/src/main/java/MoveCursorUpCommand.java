public class MoveCursorUpCommand implements Command {
    private PixelCanvas canvas;
    private DrawingBoard drawingBoard;
    private MovementCommand movementCommand;

    public MoveCursorUpCommand(PixelCanvas canvas, DrawingBoard drawingBoard) {
        this.canvas = canvas;
        this.drawingBoard = drawingBoard;
        this.movementCommand = new MovementCommand(this.drawingBoard, this.canvas);
    }

    public void execute() {
        this.movementCommand.move(Direction.UP);
    }
}
