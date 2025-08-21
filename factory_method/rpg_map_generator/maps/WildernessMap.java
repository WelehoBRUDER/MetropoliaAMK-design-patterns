package rpg_map_generator.maps;
import rpg_map_generator.Map;
import rpg_map_generator.Tile;
import rpg_map_generator.tiles.Forest;
import rpg_map_generator.tiles.Water;
import rpg_map_generator.tiles.Swamp;

import java.awt.geom.GeneralPath;

public class WildernessMap extends Map {
    private Tile[][] tiles;
    private Tile[] tileTypes = {
        new Forest(),
        new Water(),
        new Swamp()
    };

    public WildernessMap(int size) {
        super(size);
    }

    @Override
    public Tile createTile() {
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }

}
