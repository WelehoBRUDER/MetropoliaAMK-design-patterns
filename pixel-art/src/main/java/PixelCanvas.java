import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PixelCanvas {
    private Canvas canvas;
    private GraphicsContext gc;
    private final int PIXEL_SIZE = 32;
    private final int LINE_WIDTH = 4;

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
        x = (int) Math.round((double) x * PIXEL_SIZE);
        y = (int) Math.round((double) y * PIXEL_SIZE);
        int HALF_LINE = (int) Math.round((double) LINE_WIDTH / 2);
        double epsilon = 0.1;
        double epsilon2 = epsilon * 2;
        this.gc.clearRect(x + epsilon, y + epsilon, PIXEL_SIZE + epsilon2, PIXEL_SIZE + epsilon2);
        if (filled) {
            this.gc.setFill(Color.BLACK);
            this.gc.fillRect(x + epsilon, y + epsilon, PIXEL_SIZE + epsilon2, PIXEL_SIZE + epsilon2);
        }
        if (selected) {
            this.gc.setLineWidth(LINE_WIDTH);
            this.gc.setStroke(Color.SILVER);
            this.gc.strokeRect(x + HALF_LINE, y + HALF_LINE, PIXEL_SIZE - LINE_WIDTH, PIXEL_SIZE - LINE_WIDTH);
        }
    }
}
