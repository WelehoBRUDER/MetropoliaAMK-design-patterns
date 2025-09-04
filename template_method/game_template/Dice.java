package game_template;

import java.util.Arrays;

public class Dice {
    public int roll(String args) {
        String[] values = args.split("d");
        int num = Integer.parseInt(values[0]);
        int die = Integer.parseInt(values[1]);
        int result = 0;
        for (int i = 1; i <= num; i++) {
            result += (int) (Math.floor(Math.random() * die) + 1);
        }
        return result;
    }
}
