package org.ecommerce.orders.observers;

import java.util.ArrayList;
import java.util.List;

public class OrderSubject {

    private final List<IOrderObserver> observers = new ArrayList<>();

    public void addObserver(IOrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IOrderObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(String event, String message) {
        for (IOrderObserver observer : observers) {
            observer.update(event, message);
        }
    }

}
