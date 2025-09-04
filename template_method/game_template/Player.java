package game_template;

public class Player {
    private int points;
    private String name;

    public Player(String name) {
        this.points = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
