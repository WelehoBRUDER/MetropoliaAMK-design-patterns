package ascii_button_factory.styles.b;

import ascii_button_factory.Checkbox;

public class CheckboxB extends Checkbox {
    public void display(String text, Boolean checked) {
        String box = checked ? "(x) " : "( ) ";
        System.out.println(box + text);
    }
}
