package ascii_button_factory.styles.b;

import ascii_button_factory.TextField;

public class TextFieldB extends TextField {
    public TextFieldB(String txt) {
        super(txt);
    }

    public void display() {
        System.out.println("{" + text + "}");
    }
}
