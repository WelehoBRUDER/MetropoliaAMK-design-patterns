package printer;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new XMLPrinter(new BasicPrinter());
        printer2.print("Hello World!");

        Printer printer3 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer3.print("Hello World!");
        printer3.print("This text should be encrypted, just like the previous one.");
    }
}
