public class GenerateCodeCommand implements Command {
    private DrawingBoard drawingBoard;

    public GenerateCodeCommand(DrawingBoard drawingBoard) {
        this.drawingBoard = drawingBoard;
    }

    @Override
    public void execute() {
        drawingBoard.generateCode();
    }
}
