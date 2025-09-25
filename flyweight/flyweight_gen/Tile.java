package flyweight_gen;

public abstract class Tile implements I_Tile {
    protected String character;
    protected String type;

    public String getCharacter() {
        return character;
    }
    public String getType() {
        return type;
    }
    public abstract void action();
}
