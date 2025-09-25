package maps;

import tiles.*;

public class CityMap extends Map {
    private TileGraphicFactory tgf = TileGraphicFactory.getInstance();
    private Tile[][] tiles;
    private Integer[] tileTypes = {
            tgf.getTileIndex("Forest"),
            tgf.getTileIndex("Road"),
            tgf.getTileIndex("Building"),
    };

    public CityMap(int size) {
        super(size);
    }

    @Override
    public Integer createTile() {
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }
}
