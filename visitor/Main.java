import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Directory dirA = new Directory("root", new ArrayList<>());
        Directory dirB = new Directory("mid", new ArrayList<>());
        Directory dirC = new Directory("loss", new ArrayList<>());
        Directory dirD = new Directory("cmx_53", new ArrayList<>());

        dirA.addElement(new File("dfjksd_3", "png", 0.386));
        dirA.addElement(new File("huge_file","zip", 964));
        dirB.addElement(new File("glhgf","png", 2));
        dirB.addElement(new File("old_ver","exe", 75.5));
        dirB.addElement(new File("liit","bmp", 3.98));
        dirC.addElement(new File("lesd","jpg", 2.66));
        dirC.addElement(new File("mgar_x25","exe", 0.75));
        dirD.addElement(new File("0000000357AB","jpg", 30));
        dirD.addElement(new File("doomed","exe", 2099));
        dirD.addElement(new File("bloom","iso", 3578));

        dirA.addElement(dirB);
        dirB.addElement(dirC);
        dirA.addElement(dirD);

        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();
        SearchVisitor searchVisitor = new SearchVisitor("exe");

        // Calculate total size from root
        sizeCalculatorVisitor.visit(dirA);
        double totalSize = sizeCalculatorVisitor.getSize();
        System.out.println("Total size of directory 'root': " + totalSize + " mb");

        // Reset counter and search only cmx_53
        sizeCalculatorVisitor.reset();
        sizeCalculatorVisitor.visit(dirD);
        System.out.println("Total size of directory 'cmx_53': " + sizeCalculatorVisitor.getSize() + " mb");

        // Find all files with extension .exe
        searchVisitor.visit(dirA);
        List<File> files = searchVisitor.getFiles();
        System.out.println("Total of " + files.size() + " entries found matching .exe extension:");
        for (File file : files) {
            System.out.println(file.getFullName() + " (" + file.getSize() + " mb)");
        }

        // Reset and instead search for extension .png
        searchVisitor.reset();
        searchVisitor.setCriteria("png");
        searchVisitor.visit(dirA);
        List<File> files2 = searchVisitor.getFiles();
        System.out.println("Total of " + files2.size() + " entries found matching .png extension:");
        for (File file : files2) {
            System.out.println(file.getFullName() + " (" + file.getSize() + " mb)");
        }
    }
}
