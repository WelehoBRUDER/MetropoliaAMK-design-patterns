package rpg_map_generator.maps;
import rpg_map_generator.Map;
import rpg_map_generator.Tile;
import rpg_map_generator.tiles.ForestTile;
import rpg_map_generator.tiles.RoadTile;
import rpg_map_generator.tiles.BuildingTile;

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
