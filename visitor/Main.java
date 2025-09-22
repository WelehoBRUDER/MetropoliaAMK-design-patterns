import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Directory dirA = new Directory("root", new ArrayList<>());
        Directory dirB = new Directory("mid", new ArrayList<>());
        Directory dirC = new Directory("loss", new ArrayList<>());
        Directory dirD = new Directory("cmx_53", new ArrayList<>());

        dirA.addElement(new File("dfjksd_3", 0.386));
        dirA.addElement(new File("huge_file", 964));
        dirB.addElement(new File("glhgf", 2));
        dirB.addElement(new File("old_ver", 75.5));
        dirB.addElement(new File("liit", 3.98));
        dirC.addElement(new File("lesd", 2.66));
        dirC.addElement(new File("mgar_x25", 0.75));
        dirD.addElement(new File("0000000357AB", 30));
        dirD.addElement(new File("doomed", 2099));
        dirD.addElement(new File("bloom", 3578));

        dirA.addElement(dirB);
        dirB.addElement(dirC);
        dirA.addElement(dirD);

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();

        sizeCalculatorVisitor.visit(dirA);
        double totalSize = sizeCalculatorVisitor.getSize();
        System.out.println("Total size: " + totalSize + " mb");
    }
}
