import java.util.List;

public class Directory implements FileSystemElement {
    private String name;
    private List<FileSystemElement> dir;

    public Directory(String name, List<FileSystemElement> dir) {
        this.name = name;
        this.dir = dir;
    }

    public void addElement(FileSystemElement element)  {
        dir.add(element);
    }

    @Override
    public String getName() {
        return name;
    }

    public List<FileSystemElement> getDir() {
        return dir;
    }
}
