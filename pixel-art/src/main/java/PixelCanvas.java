import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;

public class PixelCanvas {
    private Canvas canvas;
    private GraphicsContext gc;
    private final int PIXEL_SIZE = 64;
    private final int LINE_WIDTH = 2;
    private final int TRIANGLE_SIZE = 7;

    public PixelCanvas(int width, int height) {
        int xSize = width * PIXEL_SIZE;
        int ySize = height * PIXEL_SIZE;
        this.canvas = new Canvas(xSize, ySize);
        this.gc = canvas.getGraphicsContext2D();
        this.gc.setGlobalBlendMode(BlendMode.SRC_OVER);
        this.canvas.setScaleX(1);
        this.canvas.setScaleY(1);
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void clearCanvas() {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    public void drawPixel(int x, int y, boolean filled, boolean selected) {
        double px = (double) x * PIXEL_SIZE;
        double py = (double) y * PIXEL_SIZE;
        double HALF_LINE = (double) LINE_WIDTH / 2;
        gc.setFill(Color.WHITE);
        gc.fillRect(px, py, PIXEL_SIZE, PIXEL_SIZE);
        if (filled) {
            this.gc.setFill(Color.BLACK);
            this.gc.fillRect(px, py, PIXEL_SIZE, PIXEL_SIZE);
        }
        if (selected) {
            this.gc.setLineWidth(LINE_WIDTH);
            this.gc.setStroke(Color.GOLDENROD);
            this.gc.strokeRect(px + HALF_LINE, py + HALF_LINE, PIXEL_SIZE - LINE_WIDTH, PIXEL_SIZE - LINE_WIDTH);
            this.drawTrianglesToHighlight((int) px, (int) py);
        } else {
            this.gc.setStroke(Color.SILVER);
            this.gc.strokeRect(px + HALF_LINE, py + HALF_LINE, PIXEL_SIZE - LINE_WIDTH, PIXEL_SIZE - LINE_WIDTH);
        }
    }

    // This serves no real point, I just really wanted to make the highlight more interesting ✨
    public void drawTrianglesToHighlight(int x, int y) {
        // Calculate position for vertical triangle
        int topOffsetX = PIXEL_SIZE / 2 - TRIANGLE_SIZE / 2;
        int topX = x + topOffsetX;
        int bottomY = y + PIXEL_SIZE;
        drawVerticalTriangle(topX, y, TRIANGLE_SIZE, false);
        drawVerticalTriangle(topX, bottomY, TRIANGLE_SIZE, true);
        // Calculate position for horizontal triangle
        int leftOffsetY = PIXEL_SIZE / 2 + TRIANGLE_SIZE / 2;
        int leftY = y + leftOffsetY;
        int rightX = x + PIXEL_SIZE;
        drawHorizontalTriangle(x, leftY, TRIANGLE_SIZE, false);
        drawHorizontalTriangle(rightX, leftY, TRIANGLE_SIZE, true);
    }

    // Draws vertical triangle from top to bottom, or mirrored if boolean flip is true
    public void drawVerticalTriangle(int x, int y, int base, boolean flip) {
        // Offset the starting point by line width
        y += flip ? -LINE_WIDTH : LINE_WIDTH;
        // Start drawing the triangle
        int limit = base / 2;
        for (int i = 0; i <= limit; i++) {
            int startX = x + i;
            int startY = flip ? y - i : y + i;
            int endX = startX + (base - i * 2);
            this.gc.strokeLine(startX, startY, endX, startY);
        }
    }

    // Draws horizontal triangle from left to right, or mirrored if boolean flip is true
    public void drawHorizontalTriangle(int x, int y, int base, boolean flip) {
        // Offset the starting point by line width
        x += flip ? -LINE_WIDTH : LINE_WIDTH;
        // Start drawing the triange
        int limit = base / 2 + 1;
        for (int i = 0; i <= limit; i++) {
            int startX = flip ? x - i : x + i;
            int startY = y - i;
            int endY = startY - (base - i * 2) - 1;
            this.gc.strokeLine(startX, startY, startX, endY);
        }
    }
}
