package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的被观察者
 *
 * @author liuxucheng
 * @since 2023/1/3
 */
public class Subject implements Observable {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
