package game_template;

import game_template.decors.Colors;
import game_template.decors.Printer;

import java.util.ArrayList;
import java.util.Scanner;

// This game was created spontaneously during a DnD session
// https://docs.google.com/document/d/1761RtXJjH8jhvbmf3OlmpUtTKGmh-CvFFsg46I6WHxA/edit?usp=sharing

public class ThreeHobgoblins extends Game {
    private ArrayList<Player> players;
    private final Scanner scanner = new Scanner(System.in);
    private final Dice dice = new Dice();
    private final Printer printer = new Printer();
    private int turnGoal;
    @Override
    public void initializeGame(int numberOfPlayers) {
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            Player player = new Player(name, 6);
            players.add(player);
        }
        this.turnGoal = 0;
    }

    @Override
    public boolean endOfGame() {
        return false;
    }

    @Override
    public void playSingleTurn(int player) {
        if (players.get(player).isDefeated()) {
            System.out.println(Colors.RED.wrap(players.get(player).getName() + " is eliminated!"));
            return;
        }
        System.out.println();
        printer.printDecoratedCentered("NEXT TURN BEGINS", "*", 35, Colors.YELLOW, Colors.RESET);
        System.out.println();
        if (player == 0) {
            this.turnGoal = 0;
            while(!isGoalValid()) {
                this.turnGoal = dice.roll("3d6");
            }
            System.out.println("Rolled new challenge!");
        }
        Challenges challenge = Challenges.find(this.turnGoal);
        players.get(player).printStatus();
        System.out.println("Current challenge is " + challenge.color.wrap(challenge.toString()));
        System.out.println("Pick an action:");
        System.out.println("\t1. ⚔️ Challenge");
        System.out.println("\t2. \uD83C\uDFF3️ Fold (-1 point)");
        System.out.print("Enter action (1-2): ");
        int action = scanner.nextInt();
        if (action == 1) {
            players.get(player).challenge(this.turnGoal);
        }
        else if (action == 2) {
            if (players.get(player).getPoints() <= 1) {
                System.out.println(Colors.RED.wrap("You don't have enough points to fold! You must challenge!"));
                players.get(player).challenge(this.turnGoal);
                return;
            }
            players.get(player).fold();
        }
        else {
            System.out.println("Invalid action!");
        }
    }

    @Override
    public void displayWinner() {

    }

    public boolean isGoalValid() {
        return turnGoal > 3 && turnGoal < 18;
    }
}
