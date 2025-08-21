package rpg_map_generator.tiles;
import rpg_map_generator.Tile;

public class Building implements Tile {
    public String getCharacter() {
        return "B";
    }

    public String getType() {
        return "Building";
    }
}
