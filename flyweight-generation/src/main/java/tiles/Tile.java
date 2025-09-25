package tiles;

public abstract class Tile implements I_Tile {
    protected String character;
    protected String type;
    protected String texturePath;

    public String getCharacter() {
        return character;
    }
    public String getType() {
        return type;
    }
    public String getTexturePath() { return texturePath; }
    public abstract void action();
}
