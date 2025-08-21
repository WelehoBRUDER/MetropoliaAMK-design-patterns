package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class Swamp implements Tile {
    public String getCharacter() {
        return "^";
    }

    public String getType() {
        return "Swamp";
    }
}
