package org.ecommerce.orders.models;

import org.ecommerce.orders.observers.IObserver;
import org.ecommerce.payments.IPayment;
import org.ecommerce.products.IProduct;

import java.util.ArrayList;
import java.util.List;

public class NormalOrder implements IOrder {
    private final List<OrderItem> items = new ArrayList<>();
    private final List<IObserver> observers = new ArrayList<>();

    @Override
    public void addItem(IProduct product, int quantity) {

        items.add(new OrderItem(product, quantity));
        notifyObservers("Item added", "%s added to Normal Order".formatted(product.getName()));
    }

    @Override
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    @Override
    public void proccessOrder(IPayment payment) {
        double totalAmount = calculateTotal();
        payment.proccessPayment();
        if (payment.payment(totalAmount)) {
            notifyObservers("ORDER_PROCESSED", "Normal order processed successfully! Total: %s".formatted(totalAmount));
        } else {
            notifyObservers("ORDER_FAILED", "Payment failed. Normal order not processed.");
        }
    }

    @Override
    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String getDeliveryType() {
        return "Normal Delivery";
    }

    @Override
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event, String message) {
        for (IObserver observer : observers) {
            observer.update(event, message);
        }
    }

}