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

    public void printPlayerOptions(int level, String[] options) {
        System.out.println("Choose an option:");
        for (int i = 0; i < options.length; i++) {
            // color the option silver if available, dark gray if not
            String color = (level >= i + 1) ? "\u001B[37m" : "\u001B[90m";
            System.out.println(color + (i + 1) + ". " + options[i]);
        }
        // reset color
        System.out.print("\u001B[0m");
    }

    public void playerOptions() {
        int level = this.getPC().getLvl();
        String[] options = {"💪 Train", "🧘 Meditate", "⚔️ Fight"};
        printPlayerOptions(level, options);
        int choice = 0;
        try {
            choice = scanner.nextInt();
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid choice. Please try again.");
                playerOptions();
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // clear invalid input
            playerOptions();
        }
        switch (choice) {
            case 1:
                this.getPC().train();
                break;

            case 2:
                this.getPC().meditate();
                break;

            case 3:
                this.getPC().fight();
                break;
        }
    }
}
