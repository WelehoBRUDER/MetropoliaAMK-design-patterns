package game;

public class PlayerCharacter {
    private String name;
    private int hp;
    private int lvl;
    private int xp;

    public PlayerCharacter(String name) {
        this.name = name;
        this.hp = 10; // Default health points
        this.lvl = 1;  // Starting level
        this.xp = 0;   // Starting experience points
    }

    public boolean canTrain() {
        return true;
    }

    public boolean canMeditate() {
        return this.lvl > 1;
    }

    public boolean canFight() {
        return this.lvl > 2;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getLvl() {
        return lvl;
    }

    public int getXp() {
        return xp;
    }

    public void addHp(int amount) {
        this.hp += amount;
    }

    public void addXp(int amount) {
        this.xp += amount;
    }
}
