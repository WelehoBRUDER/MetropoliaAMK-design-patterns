package game.states;

import game.Game;
import game.State;

public class IntermeditateState extends State {

    public IntermeditateState(Game game) {
        super(game);

    }


    public void action() {
        if (this.getGame().getPC().getLvl() >= 3) {
            this.getGame().setState(new ExpertState(this.getGame()));
            return;
        }
        this.getGame().getPC().printStatus();
        this.getGame().playerOptions();
    }
}
