package game;

import game.states.NoviceState;

import java.util.Scanner;

public class Game {
    private static Scanner scanner = new Scanner(System.in);
    private State state;
    private PlayerCharacter pc;
    private boolean gameOver = false;

    public Game() {
        createPlayer();
        state = new NoviceState(this);
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
        while (!gameOver) {
            if (state == null) {
                // should never happen
                System.out.println("Invalid game state");
                return;
            }
            state.action();
        }
        System.out.println("Game Over.");
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int readUserChoice(String[] options) {
        System.out.println("\nSelect an option:");
        for (int i = 1; i <= options.length; i++) {
            System.out.println(i + ". " + options[i-1]);
        }
        try {
            int choice = scanner.nextInt();
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid choice. Please try again.");
                return readUserChoice(options);
            }
            return choice;
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear invalid input
            return readUserChoice(options);
        }
    }
}
