package flyweight_gen.maps;
import flyweight_gen.Map;
import flyweight_gen.Tile;
import flyweight_gen.tiles.ForestTile;
import flyweight_gen.tiles.RoadTile;
import flyweight_gen.tiles.BuildingTile;

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
