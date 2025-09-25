package maps;

import tiles.Tile;
import tiles.ForestTile;
import tiles.RoadTile;
import tiles.BuildingTile;

public class CityMap extends Map {
    private Tile[][] tiles;
    private Tile[] tileTypes = {
            new ForestTile(),
            new RoadTile(),
            new BuildingTile()
    };

    public CityMap(int size) {
        super(size);
    }

    @Override
    public Tile createTile() {
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }
}
