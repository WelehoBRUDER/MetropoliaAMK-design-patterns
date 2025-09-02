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

    public void train() {
        if (this.canTrain()) {
            this.addXp(10);
            System.out.println(this.name + " trained and gained 10 XP!");
        }
    }

    public int getRequiredXp() {
        int[] tiers = {100, 300, 2500};
        return tiers[this.lvl - 1];
    }

    public void printStatus() {
        String nameString = "<---- " + this.name + " ---->";
        System.out.println(nameString);
        System.out.println("HP: " + this.hp);
        System.out.println("Level: " + this.lvl);
        System.out.println("XP: " + this.xp + "/" + this.getRequiredXp());
        System.out.println("-".repeat(nameString.length()));
    }
}
