package ascii_button_factory.styles;

import ascii_button_factory.UIFactory;
import ascii_button_factory.styles.a.ButtonA;
import ascii_button_factory.styles.a.CheckboxA;
import ascii_button_factory.styles.a.TextFieldA;

public class AFactory extends UIFactory {
    @Override
    public ascii_button_factory.Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public ascii_button_factory.TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public ascii_button_factory.Checkbox createCheckbox(String text, boolean checked) {
        return new CheckboxA(text, checked);
    }
}
