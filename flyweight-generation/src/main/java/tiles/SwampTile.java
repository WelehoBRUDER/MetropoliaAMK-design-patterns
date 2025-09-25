package tiles;

public class SwampTile extends Tile {
    public SwampTile() {
        character = "\u001B[36m^";
        type = "Swamp";
        texturePath = "/tiles/dirt.png";
    }
    public void action() {
    }
}
