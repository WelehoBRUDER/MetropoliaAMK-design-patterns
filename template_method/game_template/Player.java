package game_template;

import java.util.Scanner;

public class Player {
    private String name;
    private int points;
    private final Scanner in = new Scanner(System.in);
    private final Dice dice = new Dice();
    private final Printer printer = new Printer();
    private final int LINE_WIDTH = 35;

    public Player(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
        System.out.println("Points changed by " + points + " ( Total: " + this.points + " )");
    }

    public void printStatus() {
        System.out.println("-".repeat(LINE_WIDTH));
        System.out.println("\tPlayer: " + name);
        System.out.println("\tPoints: " + points);
        System.out.println("-".repeat(LINE_WIDTH));
    }

    public void challenge(int turnGoal) {
        Challenges challenge = Challenges.find(turnGoal);
        int maxWager = 0;
        int winMultiplier = 1;
        int winBonus = 0;
        int jackpotMultiplier = 1;

        switch (challenge) {
            case EASY:
                maxWager = 2;
                winBonus = 1;
                jackpotMultiplier = 2;
                break;
            case MODERATE:
                maxWager = 99;
                winMultiplier = 2;
                jackpotMultiplier = 3;
                break;
            case DIFFICULT:
                maxWager = 99;
                winMultiplier = 2;
                winBonus = 1;
                jackpotMultiplier = 4;
                break;
            default:
                break;
        }

        System.out.println("Maximum wager: " + maxWager);
        System.out.println("Win multiplier: " + winMultiplier + "x");
        System.out.println("Win bonus: " + winBonus);
        System.out.println("Jackpot: " + jackpotMultiplier + "x");

        System.out.print("Enter your wager (min 2): ");
        int wager = in.nextInt();
        while (wager < 2 || wager > maxWager) {
            System.out.println("Your wager must be between 2 and " + maxWager);
            System.out.print("Enter your wager (min 2): ");
            wager = in.nextInt();
        }

        this.addPoints(-wager);

        int result = dice.roll("3d6");
        System.out.println();
        printer.printDecoratedCentered("🎲 Your die roll is: " + result, "#", LINE_WIDTH);
        System.out.println();

        if (result == turnGoal) {
            System.out.println("DRAW! Your wager is returned, but you win nothing.");
            this.addPoints(wager);
        }
        else if (result == 3) {
            System.out.println("CATASTROPHIC LOSS! Your loss is doubled!");
            this.addPoints(-wager);
        }
        else if (result == 18) {
            System.out.println("JACKPOT! Your win is greater than expected!");
            this.addPoints(wager * jackpotMultiplier);
        }
        else if (result < turnGoal) {
            System.out.println("LOSE! You just didn't roll high enough.");
        }
        else if (result > turnGoal) {
            System.out.println("WIN! You get to collect your winnings!");
            this.addPoints(wager * winMultiplier + winBonus);
        }
    }


    public void fold() {
        this.addPoints(-1);
        System.out.println(this.name + " has folded.");
    }
}
