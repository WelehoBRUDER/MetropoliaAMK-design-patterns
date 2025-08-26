package ascii_button_factory.styles.a;

import ascii_button_factory.Checkbox;

public class CheckboxA extends Checkbox {
    public void display(String text, Boolean checked) {
        String box = checked ? "[x] " : "[ ] ";
        System.out.println(box + text);
    }
}
