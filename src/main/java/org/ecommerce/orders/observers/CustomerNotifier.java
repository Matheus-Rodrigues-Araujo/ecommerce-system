package org.ecommerce.orders.observers;

public class CustomerNotifier implements IOrderObserver {
    @Override
    public void update(String event, String message) {
        System.out.printf("NOTIFICATION [%s]: %s%n", event, message);
    }
}
