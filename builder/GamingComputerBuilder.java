public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildOS() {
        computer.setOS("Windows 11");
    }

    @Override
    public void buildCPU() {
        computer.setCPU("AMD RYZEN 7 9800X 3D");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("NVIDIA RTX 4080");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(32);
    }

    @Override
    public void buildDisk() {
        computer.setDisk(new HardDrive(2048, "M.2 SSD"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
