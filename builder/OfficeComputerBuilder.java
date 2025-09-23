public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildOS() {
        computer.setOS("Windows 10");
    }

    @Override
    public void buildCPU() {
        computer.setCPU("Intel i3-7100");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("Intel integrated graphics card");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(16);
    }

    @Override
    public void buildDisk() {
        computer.setDisk(new HardDrive(512, "HDD"));
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
