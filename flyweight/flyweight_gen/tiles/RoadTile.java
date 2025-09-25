package flyweight_gen.tiles;
import flyweight_gen.Tile;

public class RoadTile extends Tile {
    public RoadTile() {
        character = "\u001B[33m-";
        type = "Road";
    }
    public void action() {
    }
}

