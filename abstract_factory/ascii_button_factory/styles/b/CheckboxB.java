package ascii_button_factory.styles.b;

import ascii_button_factory.Checkbox;

public class CheckboxB extends Checkbox {
    public CheckboxB(String txt, Boolean chk) {
        super(txt, chk);
    }

    public void display() {
        String box = checked ? "(x) " : "( ) ";
        System.out.println(box + text);
    }
}
