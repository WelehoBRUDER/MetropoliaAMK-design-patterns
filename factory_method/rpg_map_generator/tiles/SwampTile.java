package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class SwampTile extends Tile {
    public SwampTile() {
        character = "\u001B[36m^";
        type = "Swamp";
    }
    public void action() {
    }
}
