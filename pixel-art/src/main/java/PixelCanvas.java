import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PixelCanvas {
    private Canvas canvas;
    private GraphicsContext gc;
    private final int PIXEL_SIZE = 32;
    private final int LINE_WIDTH = 2;

    public PixelCanvas(int width, int height) {
        int xSize = width * PIXEL_SIZE;
        int ySize = height * PIXEL_SIZE;
        this.canvas = new Canvas(xSize, ySize);
        this.gc = canvas.getGraphicsContext2D();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void clearCanvas() {
        this.canvas = new Canvas();
    }

    public void drawPixel(int x, int y, boolean filled, boolean selected) {
        x *= PIXEL_SIZE;
        y *= PIXEL_SIZE;
        System.out.println("x: " + x + ", y: " + y + ", filled: " + filled + ", selected: " + selected);
        this.gc.clearRect(x, y, PIXEL_SIZE, PIXEL_SIZE);
        if (filled) {
            this.gc.setFill(Color.BLACK);
            this.gc.fillRect(x, y, PIXEL_SIZE, PIXEL_SIZE);
        }
        if (selected) {
            this.gc.setLineWidth(LINE_WIDTH);
            this.gc.setStroke(Color.SILVER);
            this.gc.strokeRect(x + LINE_WIDTH / 2, y + LINE_WIDTH / 2, PIXEL_SIZE - LINE_WIDTH, PIXEL_SIZE - LINE_WIDTH);
        }
    }
}
