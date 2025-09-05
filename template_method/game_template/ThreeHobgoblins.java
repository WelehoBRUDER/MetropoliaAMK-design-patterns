package game_template;

import game_template.decors.Colors;
import game_template.decors.Printer;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreeHobgoblins extends Game {
    private ArrayList<Player> players;
    private final Scanner scanner = new Scanner(System.in);
    private final Dice dice = new Dice();
    private final Printer printer = new Printer();
    private int turnGoal;
    private int gameGoal;
    private int rounds = 0;

    @Override
    public void initializeGame(int numberOfPlayers) {

        this.players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String name = scanner.nextLine();

            int STARTING_POINTS = 6;
            Player player = new Player(name, STARTING_POINTS);
            players.add(player);
        }
        this.turnGoal = 0;
    }

    public int numberOfActivePlayers() {
        int count = 0;
        for (Player player : players) {
            if (!player.isDefeated()) {
                count++;
            }
        }
        return count;
    }

    public int getWinner() {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getPoints() >= this.gameGoal) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean endOfGame() {
        if (getWinner() > -1) {
            return true;
        }
        return numberOfActivePlayers() == 0;
    }

    @Override
    public void playSingleTurn(int player) {
        if (player == 0) {
            this.turnGoal = 0;
            while(!isGoalValid()) {
                this.turnGoal = dice.roll("3d6");
            }
            rounds++;
            System.out.println();
            printer.printDecoratedCentered("ROUND " + rounds + " BEGINS!", "=", 35, Colors.CYAN, Colors.RESET);
            System.out.println();
            System.out.println("There are " + numberOfActivePlayers() + " players still in the game!");
        }

        if (players.get(player).isDefeated()) {
            System.out.println();
            System.out.println(Colors.RED.wrap(players.get(player).getName() + " is eliminated!"));
            return;
        }

        System.out.println();
        printer.printDecoratedCentered("NEXT TURN BEGINS", "*", 35, Colors.YELLOW, Colors.RESET);
        System.out.println();

        players.get(player).printStatus();
        Challenges challenge = Challenges.find(this.turnGoal);
        System.out.println("Current challenge is " + challenge.color.wrap(challenge.toString()));
        System.out.println("Pick an action:");
        System.out.println("\t1. ⚔️ Challenge");
        if (players.get(player).getPoints() <= 1) {
            System.out.println(Colors.RED.wrap("\t2. (You don't have enough points to fold!)"));
        }
        else {
            System.out.println("\t2. \uD83C\uDFF3️ Fold (-1 point)");
        }

        int action = 0;
        while(action < 1 || action > 2) {
            System.out.print("Enter action (1-2): ");
            action = scanner.nextInt();
            if (action == 1) {
                players.get(player).challenge(this.turnGoal);
            } else if (action == 2) {
                if (players.get(player).getPoints() <= 1) {
                    System.out.println(Colors.RED.wrap("You don't have enough points to fold! You must challenge!"));
                    players.get(player).challenge(this.turnGoal);
                    return;
                }
                players.get(player).fold();
            } else {
                System.out.println(Colors.RED.wrap("Enter a valid action!"));
            }
        }
    }

    @Override
    public void displayWinner() {
        System.out.println();
        System.out.println();
        if (numberOfActivePlayers() == 0) {
            System.out.println(Colors.RED.wrap("Everyone has been eliminated!"));
            System.out.println(Colors.RED.wrap("Perhaps the only winner here is the house..."));
        }
        else {
            Player winner = players.get(getWinner());
            System.out.println(Colors.GREEN.wrap("THE WINNER IS..."));
            printer.printDecoratedCentered(winner.getName(),  "=", 35, Colors.GOLD, Colors.RESET);
            System.out.println("With a total of " + Colors.GOLD.wrap(String.valueOf(winner.getPoints())) + " points!");

            // Show the final scores
            System.out.println(Colors.CYAN.wrap("Here's how you all stacked up:"));
            ArrayList<Player> sorted = getPlayersSortedByScore();
            for (int i = 0; i < sorted.size(); i++) {
                Player p = sorted.get(i);
                String line = (i + 1) + ". " + p.getName() + " - " + p.getPoints() + " points";
                if (p == winner) {
                    System.out.println(Colors.GOLD.wrap(line));
                } else {
                    System.out.println(line);
                }
            }
        }
        printer.printDecoratedCentered("GAME OVER!", "=", 35, Colors.GREEN, Colors.RESET);
    }

    public boolean isGoalValid() {
        return turnGoal > 3 && turnGoal < 18;
    }

    public void setGoal(int goal) {
        this.gameGoal = goal;
    }

    public ArrayList<Player> getPlayersSortedByScore() {
        ArrayList<Player> sorted = new ArrayList<>(players);
        sorted.sort((p1, p2) -> Integer.compare(p2.getPoints(), p1.getPoints()));
        return sorted;
    }
}
