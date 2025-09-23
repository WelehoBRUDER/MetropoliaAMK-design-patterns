public class Computer {
    private String cpu;
    private String gpu;
    private String os;
    private HardDrive disk;
    private int ram;

    public Computer() {}

    public void setCPU(String cpu) {
        this.cpu = cpu;
    }

    public void setGPU(String gpu) {
        this.gpu = gpu;
    }

    public void setOS(String os) {
        this.os = os;
    }

    public void setDisk(HardDrive disk) {
        this.disk = disk;
    }

    public void setRAM(int ram) {
        this.ram = ram;
    }

    public String toString() {
        String content = "CPU: " + cpu + "\n";
        content += "GPU: " + gpu + "\n";
        content += "OS: " + os + "\n";
        content += "DISK: " + disk.getDrive() + "\n";
        content += "RAM: " + ram + " GB\n";
        return content;
    }
}
