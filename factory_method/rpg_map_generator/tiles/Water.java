package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class Water implements Tile {
    public String getCharacter() {
        return "~";
    }

    public String getType() {
        return "Water";
    }
}
