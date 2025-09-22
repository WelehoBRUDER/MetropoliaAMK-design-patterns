import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private List<File> files;
    private String criteria;

    public SearchVisitor(String criteria) {
        this.files = new ArrayList<>();
        this.criteria = criteria;
    }

    @Override
    public void visit(File file) {
        if (file.getExtension().equals(this.criteria)) {
            this.files.add(file);
        }
    }

    @Override
    public void visit(Directory dir) {
        for (FileSystemElement element : dir.getDir()) {
            element.accept(this);
        }
    }

    public List<File> getFiles() {
        return files;
    }
}
