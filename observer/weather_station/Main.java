package weather_station;

public class Main {
    private final int simulationTime = 16; // seconds
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();

        ws.addObserver(new WeatherObserver(ws, "Observer 1"));
        ws.addObserver(new WeatherObserver(ws, "Observer 2"));
        ws.addObserver(new WeatherObserver(ws, "Observer 3's message"));

        int elapsedTime = 0;
        ws.start();
    }
}
