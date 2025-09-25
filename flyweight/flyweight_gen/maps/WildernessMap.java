package flyweight_gen.maps;
import flyweight_gen.Map;
import flyweight_gen.Tile;
import flyweight_gen.tiles.ForestTile;
import flyweight_gen.tiles.WaterTile;
import flyweight_gen.tiles.SwampTile;

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
