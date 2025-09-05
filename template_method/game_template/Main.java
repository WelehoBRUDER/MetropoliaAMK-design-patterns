package game_template;

import game_template.decors.Colors;
import game_template.decors.Printer;

import java.util.Scanner;

// This game was created spontaneously during a DnD session
// https://docs.google.com/document/d/1761RtXJjH8jhvbmf3OlmpUtTKGmh-CvFFsg46I6WHxA/edit?usp=sharing
// The digital version is somewhat simplified, and replaces the dealer with the computer.

public class Main {
    private static final Printer printer = new Printer();

    public static void main(String[] args) {
        printer.printDecoratedCentered("THREE HOBGOBLINS", "~", 50, Colors.PURPLE, Colors.GOLD);
        System.out.println("A dice game invented by a group of four hobgoblins\nwhile in service to Zodd Utarefson. Further refined\nwhen the inventors of this game played with\na group of adventurers who invaded the palace.");
        System.out.println();
        System.out.println();
        ThreeHobgoblins threeHobgoblins = new ThreeHobgoblins();

        System.out.print("Enter the number of players (1-20): ");
        Scanner sc = new Scanner(System.in);

        int players = sc.nextInt();
        while (players < 1 || players > 20) {
            System.out.println("Please enter a number between 1 and 20");
            System.out.print("Enter the number of players (1-20): ");
            players = sc.nextInt();
        }

        System.out.println("Each player will start with 6 points");
        System.out.print("Enter the point goal for the game (20-50): ");
        int goal = sc.nextInt();
        while (goal < 20 || goal > 50) {
            System.out.println("Please enter a number between 20 and 50");
            System.out.print("Enter the point goal for the game (20-50): ");
            goal = sc.nextInt();
        }

        threeHobgoblins.setGoal(goal);

        threeHobgoblins.play(players);
    }
}
