package ascii_button_factory;

import ascii_button_factory.styles.AFactory;
import ascii_button_factory.styles.BFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        Button buttonA = factoryA.createButton();
        Button buttonB = factoryB.createButton();

        TextField textFieldA = factoryA.createTextField();
        TextField textFieldB = factoryB.createTextField();

        Checkbox checkboxA = factoryA.createCheckbox();
        Checkbox checkboxB = factoryB.createCheckbox();

        buttonA.display();
        buttonB.display();

        textFieldA.display();
        textFieldB.display();

        checkboxA.display();
        checkboxB.display();
    }
}
