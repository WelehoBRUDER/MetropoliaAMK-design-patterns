package weather_station;


public class WeatherObserver implements Observer {
    private WeatherStation observable;
    private String message;

    public WeatherObserver(WeatherStation observable, String message) {
        this.observable = observable;
        this.message = message;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        String temp = String.format("%.2f", observable.getTemperature());
        System.out.println(message + " (Weather changed to: " + temp + "°C)");
    }
}
