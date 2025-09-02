package printer;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }
    public void print(String message) {
        StringBuilder cipheredMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                cipheredMessage.append(' ');
                continue;
            }
            cipheredMessage.append((char) (c + 3));
        }
        super.print(String.valueOf(cipheredMessage));
    }
}
