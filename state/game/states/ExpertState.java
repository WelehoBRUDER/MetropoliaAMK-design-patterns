package game.states;

import game.Game;
import game.State;

public class ExpertState extends State {

    public ExpertState(Game game) {
        super(game);

    }

    public void action() {
        if (this.getGame().getPC().getLvl() >= 4) {
            this.getGame().setState(new MasterState(this.getGame()));
            return;
        }
        this.getGame().getPC().printStatus();
        System.out.println("You are an Expert. You are ready for real combat.");
        this.getGame().playerOptions();
    }
}
