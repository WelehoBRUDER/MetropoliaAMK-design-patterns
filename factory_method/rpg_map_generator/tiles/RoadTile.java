package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class RoadTile extends Tile {
    public RoadTile() {
        character = "\u001B[33m-";
        type = "Road";
    }
    public void action() {
    }
}

