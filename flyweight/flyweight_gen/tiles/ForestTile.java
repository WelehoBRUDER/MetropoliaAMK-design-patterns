package flyweight_gen.tiles;
import flyweight_gen.Tile;

public class ForestTile extends Tile {
    public ForestTile() {
        character = "\u001B[32m#";
        type = "Forest";
    }
    public void action() {
    }
}

