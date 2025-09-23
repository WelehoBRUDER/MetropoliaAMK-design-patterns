public class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void setComputerBuilder(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void constructComputer() {
        computerBuilder.buildCPU();
        computerBuilder.buildGPU();
        computerBuilder.buildDisk();
        computerBuilder.buildOS();
        computerBuilder.buildRAM();
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }
}
