package designPatterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers = new ArrayList<>();

    void notify(Stock stock) {
        for (Observer observer : observers)
            observer.update(stock);
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        if (observers.contains(o))
            observers.remove(o);
    }
}
