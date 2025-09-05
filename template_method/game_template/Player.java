package game_template;

import game_template.decors.Colors;
import game_template.decors.Printer;

import java.util.Scanner;

public class Player {
    private String name;
    private int points;
    private final Scanner in = new Scanner(System.in);
    private final Dice dice = new Dice();
    private final Printer printer = new Printer();
    private final int LINE_WIDTH = 35;
    private boolean defeated = false;

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
        if (points < 0) {
            System.out.println("Points " + Colors.RED.wrap("decreased") + " by " + Math.abs(points) + " ( Total: " + this.points + " )");
        }
        else {
        System.out.println("Points " + Colors.GREEN.wrap("increased") + " by " + points + " ( Total: " + this.points + " )");
        }
    }

    public void printStatus() {
        System.out.println(Colors.PURPLE.wrap("-".repeat(LINE_WIDTH)));
        System.out.println("\tPlayer: " + name);
        System.out.println("\tPoints: " + points);
        System.out.println(Colors.PURPLE.wrap("-".repeat(LINE_WIDTH)));
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

        int wager = 1;

        if (getPoints() > 1) {

            System.out.println("Maximum wager: " + Math.min(maxWager, points));
            System.out.println("Win multiplier: " + winMultiplier + "x");
            System.out.println("Win bonus: " + winBonus);
            System.out.println("Jackpot: " + jackpotMultiplier + "x");

            System.out.print("Enter your wager (min 2): ");
            wager = in.nextInt();
            while (wager < 2 || wager > Math.min(maxWager, points)) {
                System.out.println("Your wager must be between 2 and " + Math.min(maxWager, points));
                System.out.print("Enter your wager (min 2): ");
                wager = in.nextInt();
            }

        }

        else {
            System.out.println(Colors.DANGER.wrap("You are down to your last point! You must wager it!"));
            String confirmation = "";
            while (!confirmation.equalsIgnoreCase("CHALLENGE")) {
                System.out.print(Colors.DANGER.wrap("Type 'CHALLENGE' to continue: "));
                confirmation = in.nextLine();
            }
        }

        this.addPoints(-wager);

        int result = dice.roll("3d6");
        System.out.println(Colors.BLUE);
        printer.printDecoratedCentered("🎲🎲🎲 Your die roll is: " + result, "#", LINE_WIDTH, Colors.BLUE, Colors.RESET);
        System.out.println(Colors.RESET);

        if (result == turnGoal) {
            System.out.println("DRAW! Your wager is returned, but you win nothing.");
            this.addPoints(wager);
        }
        else if (result == 3) {
            System.out.println(Colors.RED.wrap("CATASTROPHIC LOSS!") + " Your loss is doubled!");
            this.addPoints(-wager);
        }
        else if (result == 18) {
            System.out.println(Colors.GOLD.wrap("JACKPOT!") + " Your win is greater than expected!");
            this.addPoints(wager * jackpotMultiplier);
        }
        else if (result < turnGoal) {
            System.out.println(Colors.RED.wrap("LOSE!") + " You just didn't roll high enough.");
        }
        else {
            System.out.println(Colors.GREEN.wrap("WIN!") + " You get to collect your winnings!");
            this.addPoints(wager * winMultiplier + winBonus);
        }

        this.checkDefeat();
    }


    public void fold() {
        this.addPoints(-1);
        System.out.println(this.name + " has folded.");
    }

    public void checkDefeat() {
        if (this.points <= 0) {
            System.out.println(Colors.RED.wrap("You have run out of points!"));
            System.out.println(Colors.RED.wrap(this.name + " has been eliminated!"));
            defeated = true;
        }
    }

    public boolean isDefeated() {
        return defeated;
    }
}
