package ascii_button_factory.styles;

import ascii_button_factory.UIFactory;
import ascii_button_factory.styles.b.ButtonB;
import ascii_button_factory.styles.b.CheckboxB;
import ascii_button_factory.styles.b.TextFieldB;

public class BFactory extends UIFactory {
    @Override
    public ascii_button_factory.Button createButton() {
        return new ButtonB();
    }

    @Override
    public ascii_button_factory.TextField createTextField() {
        return new TextFieldB();
    }

    @Override
    public ascii_button_factory.Checkbox createCheckbox() {
        return new CheckboxB();
    }
}
