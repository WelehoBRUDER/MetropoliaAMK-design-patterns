package ascii_button_factory.styles;

import ascii_button_factory.UIFactory;
import ascii_button_factory.styles.a.ButtonA;
import ascii_button_factory.styles.a.CheckboxA;
import ascii_button_factory.styles.a.TextFieldA;

public class AFactory extends UIFactory {
    @Override
    public ascii_button_factory.Button createButton() {
        return new ButtonA();
    }

    @Override
    public ascii_button_factory.TextField createTextField() {
        return new TextFieldA();
    }

    @Override
    public ascii_button_factory.Checkbox createCheckbox() {
        return new CheckboxA();
    }
}
