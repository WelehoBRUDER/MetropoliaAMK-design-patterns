package game_template;

import java.util.ArrayList;
import java.util.Scanner;

// This game was created spontaneously during a DnD session
// https://docs.google.com/document/d/1761RtXJjH8jhvbmf3OlmpUtTKGmh-CvFFsg46I6WHxA/edit?usp=sharing

public class ThreeHobgoblins extends Game {
    private ArrayList<Player> players;
    private final Scanner scanner = new Scanner(System.in);
    private final Dice dice = new Dice();
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
        if (player == 0) {
            this.turnGoal = 0;
            while(!isGoalValid()) {
                this.turnGoal = dice.roll("3d6");
            }
            System.out.println("Rolled new challenge!");
        }
        players.get(player).printStatus();
        System.out.println("Current challenge is " + Challenges.find(this.turnGoal));
        System.out.println("Pick an action:");
        System.out.println("1. Challenge");
        System.out.println("2. Fold (-1 point)");
        int action = scanner.nextInt();
        if (action == 1) {
            players.get(player).challenge(this.turnGoal);
        }
        else if (action == 2) {
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
