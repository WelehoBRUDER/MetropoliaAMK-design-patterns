package rpg_map_generator.maps;
import rpg_map_generator.Map;
import rpg_map_generator.Tile;
import rpg_map_generator.tiles.ForestTile;
import rpg_map_generator.tiles.WaterTile;
import rpg_map_generator.tiles.SwampTile;

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
