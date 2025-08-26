package ascii_button_factory.styles.a;

import ascii_button_factory.TextField;

public class TextFieldA extends TextField {
    public TextFieldA(String txt) {
        super(txt);
    }

    public void display() {
        System.out.println("[" + text + "]");
    }
}
