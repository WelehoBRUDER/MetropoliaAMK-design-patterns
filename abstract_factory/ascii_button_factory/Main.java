package ascii_button_factory;

import ascii_button_factory.styles.AFactory;
import ascii_button_factory.styles.BFactory;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose style (A/B): ");
        String choice = scanner.nextLine().trim().toUpperCase();

        UIFactory factory = choice.equals("A") ? new AFactory() : new BFactory();

        Button button = factory.createButton("Button");
        TextField textField = factory.createTextField("TextField");
        Checkbox checkbox = factory.createCheckbox("Checkbox", true);

        button.display();
        textField.display();
        checkbox.display();

        System.out.println("--- After modification ---");

        button.setText("NewText");
        textField.setText("NewTextInField");
        checkbox.setText("NewCheck");
        checkbox.setChecked(false);

        button.display();
        textField.display();
        checkbox.display();
    }
}
