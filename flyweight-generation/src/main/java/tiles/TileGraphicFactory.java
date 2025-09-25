package tiles;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class TileGraphicFactory {
    private final List<Tile> tilesReference;
    private final List<Image> imagesReference;
    public static TileGraphicFactory instance;

    public static TileGraphicFactory getInstance() {
        if (instance == null) {
            instance = new TileGraphicFactory();
        }
        return instance;
    }

    public TileGraphicFactory() {
        this.tilesReference = new ArrayList<>();
        this.imagesReference = new ArrayList<>();
        tilesReference.add(new WaterTile());
        tilesReference.add(new ForestTile());
        tilesReference.add(new SwampTile());
        tilesReference.add(new RoadTile());
        tilesReference.add(new BuildingTile());

        for (Tile tile : tilesReference) {
            Image img = new Image(tile.getTexturePath());
            imagesReference.add(img);
        }
    }

    public Integer getTileIndex(String type) {
        int tileIndex = -1;
        for (int i = 0; i < tilesReference.size(); i++) {
            Tile tile = tilesReference.get(i);
            if (tile.getType().equals(type)) {
                tileIndex = i;
                break;
            }
        }
        return tileIndex;
    }

    public Tile getTile(int tileIndex) {
        return tilesReference.get(tileIndex);
    }

    public Image getImage(int tileIndex) {
        return imagesReference.get(tileIndex);
    }
}
