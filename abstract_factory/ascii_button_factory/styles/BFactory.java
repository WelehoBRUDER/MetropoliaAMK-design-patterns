package ascii_button_factory.styles;

import ascii_button_factory.UIFactory;
import ascii_button_factory.styles.b.ButtonB;
import ascii_button_factory.styles.b.CheckboxB;
import ascii_button_factory.styles.b.TextFieldB;

public class BFactory extends UIFactory {
    @Override
    public ascii_button_factory.Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public ascii_button_factory.TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public ascii_button_factory.Checkbox createCheckbox(String text, boolean checked) {
        return new CheckboxB(text, checked);
    }
}
