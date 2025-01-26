package org.ecommerce.orders.observers;

public class OrderLogger implements IOrderObserver {
    @Override
    public void update(String event, String message) {
        System.out.printf("LOG [%s]: %s%n", event, message);
    }
}
