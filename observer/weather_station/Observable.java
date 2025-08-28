package weather_station;

import java.util.HashSet;
import java.util.Set;

public class Observable extends Thread {
    private final Set<Observer> observers = new HashSet<>();

    public void addObserver(Observer observer) {
        System.out.println(observer + " has been added.");
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println(observer + " has been removed.");
        System.out.println("Remaining observers: " + observers.size());
    }

    public void notifyObservers() {
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Notifying " + observers.size() + " observers...");
        for (Observer observer : observers) {
            observer.update();
        }
        System.out.println("-".repeat(50));
    }
}
