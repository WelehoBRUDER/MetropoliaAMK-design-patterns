package maps;

import tiles.*;

public class WildernessMap extends Map {
    private TileGraphicFactory tgf = TileGraphicFactory.getInstance();
    private Tile[][] tiles;
    private Integer[] tileTypes = {
        tgf.getTileIndex("Forest"),
        tgf.getTileIndex("Water"),
        tgf.getTileIndex("Swamp"),
    };

    public WildernessMap(int size) {
        super(size);
    }

    @Override
    public Integer createTile() {
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }

}
