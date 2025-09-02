package game;

import game.states.NoviceState;

import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private State state;
    private PlayerCharacter pc;

    public Game() {
        pc = new PlayerCharacter("Hero");
        state = new NoviceState(this);
        // createPlayer();
    }

    public void createPlayer() {
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();
        pc = new PlayerCharacter(name);
    }

    public PlayerCharacter getPC() {
        return pc;
    }

    public void operate() {
        while (true) {
            if (state == null) {
                // should never happen
                System.out.println("Invalid game state");
                return;
            }
            state.action();
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public int readUserChoice(String[] options) {
        // print options
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        // read user input
        return scanner.nextInt();
    }
}
