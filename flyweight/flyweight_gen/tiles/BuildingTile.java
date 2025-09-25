package flyweight_gen.tiles;
import flyweight_gen.Tile;

public class BuildingTile extends Tile {
    public BuildingTile() {
        character = "\u001B[37mB";
        type = "Building";
    }
    public void action() {
    }
}
