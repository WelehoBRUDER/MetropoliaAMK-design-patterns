public class Main {
    public static void main(String[] args) {
        // Create director
        ComputerDirector director = new ComputerDirector(new GamingComputerBuilder());
        director.constructComputer();
        System.out.println("---< Gaming PC >---");
        System.out.println(director.getComputer().toString());
        director.setComputerBuilder(new OfficeComputerBuilder());
        director.constructComputer();
        System.out.println("---< Office PC >---");
        System.out.println(director.getComputer().toString());
    }
}
