package maps;

import tiles.Tile;
import tiles.ForestTile;
import tiles.WaterTile;
import tiles.SwampTile;

public class WildernessMap extends Map {
    private Tile[][] tiles;
    private Tile[] tileTypes = {
        new ForestTile(),
        new WaterTile(),
        new SwampTile()
    };

    public WildernessMap(int size) {
        super(size);
    }

    @Override
    public Tile createTile() {
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }

}
