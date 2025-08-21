package rpg_map_generator.maps;
import rpg_map_generator.Map;
import rpg_map_generator.Tile;
import rpg_map_generator.tiles.Forest;
import rpg_map_generator.tiles.Road;
import rpg_map_generator.tiles.Building;

public class CityMap extends Map {
    private Tile[][] tiles;
    private Tile[] tileTypes = {
            new Forest(),
            new Road(),
            new Building()
    };

    public CityMap(int size) {
        super(size);
    }

    @Override
    public Tile createTile() {
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }
}
