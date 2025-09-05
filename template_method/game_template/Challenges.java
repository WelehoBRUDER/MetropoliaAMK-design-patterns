package game_template;

import game_template.decors.Colors;

public enum Challenges {
    EASY(4, 6, Colors.GREEN),
    MODERATE(7, 13, Colors.YELLOW),
    DIFFICULT(14, 17, Colors.RED);

    private final int min;
    private final int max;
    public final Colors color;

    // Constructor for the enum
    Challenges(int min, int max, Colors color) {
        this.min = min;
        this.max = max;
        this.color = color;
    }

    public static Challenges find(int value) {
        for (Challenges c : Challenges.values()) {
            if (value >= c.min && value <= c.max) {
                return c;
            }
        }
        throw new IllegalArgumentException("No challenge matches value: " + value);
    }
}
