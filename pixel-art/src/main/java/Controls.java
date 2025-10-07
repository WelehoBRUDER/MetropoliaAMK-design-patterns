public class Controls {
    private Command moveCursorLeft;
    private Command moveCursorRight;
    private Command moveCursorUp;
    private Command moveCursorDown;
    private Command togglePixel;
    private Command generateCode;

    public Controls(Command moveCursorLeft, Command moveCursorRight, Command moveCursorUp, Command moveCursorDown, Command togglePixel, Command generateCode) {
        this.moveCursorLeft = moveCursorLeft;
        this.moveCursorRight = moveCursorRight;
        this.moveCursorUp = moveCursorUp;
        this.moveCursorDown = moveCursorDown;
        this.togglePixel = togglePixel;
        this.generateCode = generateCode;
    }

    public void moveCursorLeft() {
        moveCursorLeft.execute();
    }

    public void moveCursorRight() {
        moveCursorRight.execute();
    }

    public void moveCursorUp() {
        moveCursorUp.execute();
    }

    public void moveCursorDown() {
        moveCursorDown.execute();
    }

    public void togglePixel() {
        togglePixel.execute();
    }

    public void generateCode() {
        generateCode.execute();
    }
}
