public class File implements FileSystemElement {
    private String name;
    private double size;

    @Override
    public String getName() {
        return this.name;
    }

    public double getSize() {
        return this.size;
    }
}
