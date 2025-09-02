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
        String[] options = {"Train", "Meditate", "Fight"};
        this.getGame().getPC().printStatus();
        System.out.println("You are an Expert. You are ready for real combat.");
        switch (this.getGame().readUserChoice(options)) {
            case 1:
                this.getGame().getPC().train();
                break;

            case 2:
                this.getGame().getPC().meditate();
                break;

            case 3:
                this.getGame().getPC().fight();
                break;
        }
    }
}
