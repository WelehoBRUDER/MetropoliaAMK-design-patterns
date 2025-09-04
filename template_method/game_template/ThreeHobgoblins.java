package game_template;

import java.util.ArrayList;
import java.util.Scanner;

public class ThreeHobgoblins extends Game {
    private ArrayList<Player> players;
    private final Scanner scanner = new Scanner(System.in);
    private int turnGoal;
    @Override
    public void initializeGame(int numberOfPlayers) {
        this.players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            Player player = new Player(name);
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
            // Decide who rolls
        }
    }

    @Override
    public void displayWinner() {

    }
}
