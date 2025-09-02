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
        String[] options = {"Train", "Meditate"};
        this.getGame().getPC().printStatus();
        System.out.println("You are at an Intermediate level. You can either train or meditate.");
        switch (this.getGame().readUserChoice(options)) {
            case 1:
                this.getGame().getPC().train();
                break;

            case 2:
                this.getGame().getPC().meditate();
                break;
        }
    }
}
