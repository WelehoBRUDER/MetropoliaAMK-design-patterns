package ascii_button_factory.styles.a;

import ascii_button_factory.Button;

public class ButtonA extends Button {
    @Override
    public void display(String text) {
        int length = 16;
        String border = "-".repeat(length);
        String padding = " ".repeat((length - text.length() - 2) / 2);
        System.out.println(" " + border);
        System.out.println("|" + padding + (text.length() % 2 == 0 ? "" : " ") + text + padding + "  |");
        System.out.println(" " + border);
    }
}
