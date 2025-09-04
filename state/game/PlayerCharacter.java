package game;

public class PlayerCharacter {
    private String name;
    private int hp;
    private int lvl;
    private int xp;
    private final PrintDecorator decorator = new PrintDecorator();

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
            String message = this.name + " trained and gained " + amount +" XP!";
            decorator.print(message, PrintColors.BLUE);
            this.addXp(amount);
        }
    }

    public void meditate() {
        if (this.canMeditate()) {
            int xpAmount = random(1, 5);
            int hpAmount = random(1, 10);
            String message = this.name + " meditated and gained " + hpAmount + "HP and " + xpAmount + " XP!";
            decorator.print(message, PrintColors.BLUE);
            this.addXp(xpAmount);
            this.addHp(hpAmount);
        }
        else {
            decorator.print(this.name + " is not experienced enough to meditate!", PrintColors.RED);
        }
    }

    public void fight() {
        if (this.canFight()) {
            int damage = random(5, 15);
            int xpAmount = random(30, 100);
            String message = this.name + " fought bravely and took " + damage + " damage but gained " + xpAmount + " XP!";
            decorator.print(message, PrintColors.BLUE);
            this.addHp(-damage);
            this.addXp(xpAmount);
        }
        else {
            decorator.print(this.name + " is not experienced enough to fight!", PrintColors.RED);
        }

    }

    public int getRequiredXp() {
        int[] tiers = {50, 300, 1000, 10000};
        return tiers[this.lvl - 1];
    }

    public void checkLevelUp() {
        while (this.xp >= this.getRequiredXp() && this.lvl < 4) {
            this.lvl++;
            String message = this.name + " leveled up to level " + this.lvl + "!";
            decorator.print(message, PrintColors.GREEN);
        }
    }

    public void printStatus() {
        decorator.printToLine("<---- ", PrintColors.GOLD);
        System.out.print(this.name);
        decorator.printToLine(" ---->", PrintColors.GOLD);
        System.out.println();
        int len = ("<---- " + this.name + " ---->").length();
        System.out.println("HP: " + this.hp);
        System.out.println("Level: " + this.lvl);
        System.out.println("XP: " + this.xp + "/" + this.getRequiredXp());
        decorator.print("-".repeat(len), PrintColors.GOLD);
    }
}
