public class Main {

    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new SmartTV());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with smart remote.");
        SmartRemote smartRemote = new SmartRemote(device);
        smartRemote.power();
        smartRemote.voiceControl();
        device.printStatus();

        if (device instanceof SmartTV smartTV) {
            System.out.println("Tests with smart TV.");
            smartRemote.power();
            smartTV.browseInternet("https://www.google.com");
            device.printStatus();
            smartTV.stopBrowsingInternet();
            device.printStatus();
        }
    }

}
