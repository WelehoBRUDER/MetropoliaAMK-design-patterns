package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class WaterTile extends Tile {
    public WaterTile() {
        character = "\u001B[34m~";
        type = "Water";
    }
    public void action() {
    }
}