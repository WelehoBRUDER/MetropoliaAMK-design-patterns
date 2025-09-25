package flyweight_gen.tiles;
import flyweight_gen.Tile;

public class SwampTile extends Tile {
    public SwampTile() {
        character = "\u001B[36m^";
        type = "Swamp";
    }
    public void action() {
    }
}
