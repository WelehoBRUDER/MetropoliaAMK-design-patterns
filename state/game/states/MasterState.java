package game.states;

import game.Game;
import game.State;

public class MasterState extends State {

    public MasterState(Game game) {
        super(game);

    }

    public void action() {
        this.getGame().getPC().printStatus();
        System.out.println("You are a Master. You have reached the pinnacle of your abilities.");
        System.out.println("There is nothing more to do here. You have completed the game!");
        this.getGame().setGameOver(true);
    }
}
