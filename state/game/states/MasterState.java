package game.states;

import game.Game;
import game.State;

public class MasterState extends State {

    public MasterState(Game game) {
        super(game);

    }

    public void action() {
        String[] options = {"Train"};
        switch (this.getGame().readUserChoice(options)) {
            case 1:
                //this.getGame().setState(new TicketSelectionState(this.getMachine()));
                break;
        }
    }
}
