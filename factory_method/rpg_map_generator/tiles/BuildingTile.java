package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class BuildingTile extends Tile {
    public BuildingTile() {
        character = "\u001B[37mB";
        type = "Building";
    }
    public void action() {
    }
}
