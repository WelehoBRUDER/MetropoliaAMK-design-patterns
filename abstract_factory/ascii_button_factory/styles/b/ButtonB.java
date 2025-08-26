package ascii_button_factory.styles.b;

import ascii_button_factory.Button;

public class ButtonB extends Button {
    @Override
    public void display() {
        int length = 20;

        if (text.length() > length) {
            text = text.substring(0, length - 3) + "...";
        }

        int paddingLength = length - text.length();
        int left = paddingLength / 2;
        int right = paddingLength - left;
        String border = "*".repeat(length);
        System.out.println(" " + border);
        System.out.println("{" + " ".repeat(left) + text + " ".repeat(right) + "}");
        System.out.println(" " + border);
    }
}
