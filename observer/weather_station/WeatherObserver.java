package weather_station;


public class WeatherObserver implements Observer {
    private WeatherStation observable;

    public WeatherObserver(WeatherStation observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Weather changed to: " + observable.getTemperature() + "°C");
    }
}
