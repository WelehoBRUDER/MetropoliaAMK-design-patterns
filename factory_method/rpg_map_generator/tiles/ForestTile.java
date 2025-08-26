package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class ForestTile extends Tile {
    public ForestTile() {
        character = "\u001B[32m#";
        type = "Forest";
    }
    public void action() {
    }
}

