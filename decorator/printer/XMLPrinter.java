package printer;

public class XMLPrinter extends PrinterDecorator {

    public XMLPrinter(Printer printer) {
        super(printer);
    }
    public void print(String message) {
        System.out.println("<message>" + message + "</message>");
    }
}
