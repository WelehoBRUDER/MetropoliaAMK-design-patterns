package tiles;

public class WaterTile extends Tile {
    public WaterTile() {
        character = "\u001B[34m~";
        type = "Water";
        texturePath = "/tiles/water.png";
    }
    public void action() {
    }
}