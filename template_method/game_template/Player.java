package game_template;

import java.util.Scanner;

public class Player {
    private String name;
    private int points;
    private Scanner in = new Scanner(System.in);

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
    }

    public void printStatus() {
        System.out.println("-".repeat(25));
        System.out.println("Player: " + name);
        System.out.println("Points: " + points);
        System.out.println("-".repeat(25));
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
        System.out.println("Jackpot: " + jackpotMultiplier);

        System.out.print("Enter your wager (min 2): ");
        int wager = in.nextInt();
    }


    public void fold() {
        this.points--;
    }
}
