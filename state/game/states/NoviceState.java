package game.states;

import game.Game;
import game.State;

public class NoviceState extends State {

    public NoviceState(Game game) {
        super(game);

    }

    public void action() {
        if (this.getGame().getPC().getLvl() >= 2) {
            this.getGame().setState(new IntermeditateState(this.getGame()));
            return;
        }
        this.getGame().getPC().printStatus();
        System.out.println("You are a Novice. You can only train to improve your skills.");
        this.getGame().playerOptions();
    }
}
