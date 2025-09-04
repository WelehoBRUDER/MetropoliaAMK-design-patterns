package game_template;

import java.util.Arrays;

public class Dice {
    public int rollDice(String args) {
        String[] result = args.split("d");
        System.out.println(Arrays.toString(result));
        return 0;
    }
}
