package game_template;

public class Printer {
    public void printCentered(String text, int width) {
        if (text.length() >= width) {
            System.out.println(text);
            return;
        }
        int padding = (width - text.length()) / 2;
        String format = "%" + (padding + text.length()) + "s";
        System.out.printf(format, text);
        System.out.println();
    }

    public void printDecoratedCentered(String text, String dec, int width) {
        System.out.println(dec.repeat(width));
        printCentered(text, width);
        System.out.println(dec.repeat(width));
    }
}
