package game.states;

import game.Game;
import game.State;

public class ExpertState extends State {

    public ExpertState(Game game) {
        super(game);

    }

    public void action() {
        String[] options = {"Train", "Meditate", "Fight"};
        switch (this.getGame().readUserChoice(options)) {
            case 1:
                //this.getGame().setState();
                break;
        }
    }
}
