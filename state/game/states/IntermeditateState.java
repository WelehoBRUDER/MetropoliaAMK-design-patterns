package game.states;

import game.Game;
import game.State;

public class IntermeditateState extends State {

    public IntermeditateState(Game game) {
        super(game);

    }

    public void action() {
        String[] options = {"Train", "Meditate"};
        switch (this.getGame().readUserChoice(options)) {
            case 1:
                //this.getGame().setState();
                break;
        }
    }
}
