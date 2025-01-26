package org.ecommerce.orders.observers;

public interface IObserver {
    void update(String event, String message);
}