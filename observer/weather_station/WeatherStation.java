package weather_station;

public class WeatherStation extends Observable {
    private double temperature;
    private double minTemperature;
    private double maxTemperature;
    private double minVariance;
    private double maxVariance;

    public WeatherStation() {
        this.minTemperature = -50.0;
        this.maxTemperature = 50.0;
        this.minVariance = -1.5;
        this.maxVariance = 1.5;
        randomizeInitialTemperature();
    }

    public WeatherStation(double minTemperature, double maxTemperature, double minVariance, double maxVariance) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.minVariance = minVariance;
        this.maxVariance = maxVariance;
        randomizeInitialTemperature();
    }

    public void randomizeInitialTemperature() {
        this.temperature = minTemperature + Math.random() * (maxTemperature - minTemperature);
    }

    public double getTemperature() {
        return temperature;
    }

    public void updateTemperature() {
        double variance = minVariance + Math.random() * (maxVariance - minVariance);
        temperature += variance;
        if (temperature < minTemperature) {
            temperature = minTemperature;
        } else if (temperature > maxTemperature) {
            temperature = maxTemperature;
        }
    }
}
