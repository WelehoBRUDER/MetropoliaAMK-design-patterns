package game_template;

public enum Challenges {
    EASY(4, 6),
    MODERATE(7, 13),
    DIFFICULT(14, 17);

    private final int min;
    private final int max;

    // Constructor for the enum
    Challenges(int min, int max) {
        this.min = min;
        this.max = max;
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
