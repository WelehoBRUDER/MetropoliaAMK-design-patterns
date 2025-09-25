package flyweight_gen.tiles;
import flyweight_gen.Tile;

public class WaterTile extends Tile {
    public WaterTile() {
        character = "\u001B[34m~";
        type = "Water";
    }
    public void action() {
    }
}