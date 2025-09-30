import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import maps.Map;
import tiles.TileGraphicFactory;

public class RenderMap extends Application {
    private final int TILE_SIZE = 32; // pixels

    private TileGraphicFactory tgf = TileGraphicFactory.getInstance();
    private Canvas canvas;
    private static Map map;

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        tgf.createImageReferences();

        canvas = new Canvas();
        root.getChildren().add(canvas);

        renderMap();

        stage.setTitle("FlyweightRPGMapGen");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void setMap(Map _map) {
        map = _map;
    }

    public void renderMap() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.setWidth(TILE_SIZE * map.getTiles().length);
        canvas.setHeight(TILE_SIZE * map.getTiles().length);
        for (int y = 0; y < map.getTiles().length; y++) {
            for (int x = 0; x < map.getTiles()[y].length; x++) {
                int tile = map.getTiles()[y][x];
                Image img = tgf.getImage(tile);
                gc.drawImage(img, x * TILE_SIZE, y * TILE_SIZE);
            }
        }
    }
}
