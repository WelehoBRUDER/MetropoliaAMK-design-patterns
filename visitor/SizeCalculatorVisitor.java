import java.util.ArrayList;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private double size;

    public SizeCalculatorVisitor() {
        this.size = 0;
    }

    public void reset() {
        this.size = 0;
    }

    @Override
    public void visit(File file) {
        this.size += file.getSize();
    }

    @Override
    public void visit(Directory dir) {
        for (FileSystemElement element : dir.getDir()) {
            element.accept(this);
        }
    }

    public double getSize() {
        return this.size;
    }
}
