public interface ComputerBuilder {
    void buildOS();
    void buildCPU();
    void buildGPU();
    void buildRAM();
    void buildDisk();
    Computer getComputer();
}
