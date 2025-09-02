package printer;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer) {
        super(printer);
    }
    public void print(String message) {
        super.print("<message>" + message + "</message>");
    }
}
