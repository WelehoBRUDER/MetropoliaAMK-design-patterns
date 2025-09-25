package tiles;

public class ForestTile extends Tile {
    public ForestTile() {
        character = "\u001B[32m#";
        type = "Forest";
        texturePath = "/tiles/grass_seamless.png";
    }
    public void action() {
    }
}

