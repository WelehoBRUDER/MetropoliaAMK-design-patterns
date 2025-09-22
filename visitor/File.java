public class File implements FileSystemElement {
    private String name;
    private String extension;
    private double size;

    public File(String name, String extension, double size) {
        this.name = name;
        this.extension = extension;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public String getExtension() {
        return this.extension;
    }

    public double getSize() {
        return this.size;
    }

    public String getFullName() {
        return this.name + "." + this.extension;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
