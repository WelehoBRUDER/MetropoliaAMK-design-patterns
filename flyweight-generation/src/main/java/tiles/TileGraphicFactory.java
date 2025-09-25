package tiles;

import java.util.ArrayList;
import java.util.List;

public class TileGraphicFactory {
    private List<Tile> tilesReference;
    public static TileGraphicFactory instance;

    public static TileGraphicFactory getInstance() {
        if (instance == null) {
            instance = new TileGraphicFactory();
        }
        return instance;
    }

    public TileGraphicFactory() {
        this.tilesReference = new ArrayList<Tile>();
        tilesReference.add(new WaterTile());
        tilesReference.add(new ForestTile());
        tilesReference.add(new SwampTile());
        tilesReference.add(new RoadTile());
        tilesReference.add(new BuildingTile());
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


//    private Integer[][] createFlyweightMap(Tile[][] tiles) {
//        Integer[][] map = new Integer[tiles.length][tiles[0].length];
//        for (int y = 0; y < tiles.length; y++) {
//            for (int x = 0; x < tiles[y].length; x++) {
//                String type = tiles[y][x].getType();
//            }
//        }
//    }
}
