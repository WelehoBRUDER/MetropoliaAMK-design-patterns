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
        this.checkLevelUp();
    }

    public int random(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    public void train() {
        if (this.canTrain()) {
            int amount = random(5, 10);
            System.out.println(this.name + " trained and gained " + amount +" XP!");
            this.addXp(amount);
        }
    }

    public void meditate() {
        if (this.canMeditate()) {
            int xpAmount = random(1, 5);
            int hpAmount = random(1, 10);
            System.out.println(this.name + " meditated and gained " + hpAmount + "HP and " + xpAmount + " XP!");
            this.addXp(xpAmount);
            this.addHp(hpAmount);
        }
        else {
            // Color this text red

            System.out.println(this.name + " is not experienced enough to meditate!");
        }
    }

    public void fight() {
        if (this.canFight()) {
            int damage = random(5, 15);
            int xpAmount = random(30, 100);
            System.out.println(this.name + " fought bravely and took " + damage + " damage but gained " + xpAmount + " XP!");
            this.addHp(-damage);
            this.addXp(xpAmount);
        }
        else {
            System.out.println(this.name + " is not experienced enough to fight!");
        }

    }

    public int getRequiredXp() {
        int[] tiers = {50, 300, 1000, 10000};
        return tiers[this.lvl - 1];
    }

    public void checkLevelUp() {
        while (this.xp >= this.getRequiredXp() && this.lvl < 4) {
            this.lvl++;
            System.out.println(this.name + " leveled up to level " + this.lvl + "!");
        }
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
