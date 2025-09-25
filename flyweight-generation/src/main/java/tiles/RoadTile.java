package tiles;

public class RoadTile extends Tile {
    public RoadTile() {
        character = "\u001B[33m-";
        type = "Road";
        texturePath = "/tiles/gravel.png";
    }
    public void action() {
    }
}

