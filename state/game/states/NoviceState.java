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
        String[] options = {"Train"};
        this.getGame().getPC().printStatus();
        System.out.println("You are a Novice. You can only train to improve your skills.");
        switch (this.getGame().readUserChoice(options)) {
            case 1:
                this.getGame().getPC().train();
                break;
        }
    }
}
