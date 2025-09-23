public class HardDrive {
    private int size;
    private String type;

    public HardDrive(int size, String type) {
        this.size = size;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getDrive() {
        return size + " GB " + type;
    }
}
