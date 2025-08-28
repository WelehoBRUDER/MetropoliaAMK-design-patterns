package weather_station;

public class Main {
    private static final int simulationTime = 10; // seconds
    public static void main(String[] args) throws InterruptedException {
        WeatherStation ws = new WeatherStation();

        Observer obs1 = new WeatherObserver(ws, "Observer 1 is here");
        Observer obs2 = new WeatherObserver(ws, "[]Observer 2");
        Observer obs3 = new WeatherObserver(ws, "Observer 3's message");
        ws.addObserver(obs1);
        ws.addObserver(obs2);
        ws.addObserver(obs3);

        ws.start();

        Thread.sleep(simulationTime * 1000);

        ws.removeObserver(obs2);
    }
}
