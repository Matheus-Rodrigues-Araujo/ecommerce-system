package org.ecommerce.orders.models;

import org.ecommerce.orders.observers.IObserver;
import org.ecommerce.payments.IPayment;
import org.ecommerce.products.IProduct;

import java.util.ArrayList;
import java.util.List;

public class ExpressOrder implements IOrder {
    private final List<OrderItem> items = new ArrayList<>();
    private final List<IObserver> observers = new ArrayList<>();
    private static final double EXPRESS_DELIVERY_FEE = 20.00;

    @Override
    public void addItem(IProduct product, int quantity) {
        items.add(new OrderItem(product, quantity));
        notifyObservers("ITEM_ADDED", "Product added: %s, Quantity: %d".formatted(product.getName(), quantity));
    }

    @Override
    public double calculateTotal() {
        double subTotal = items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        return subTotal + EXPRESS_DELIVERY_FEE;
    }

    @Override
    public void proccessOrder(IPayment payment) {
        double totalAmount = calculateTotal();
        payment.proccessPayment();
        if (payment.payment(totalAmount)) {
            notifyObservers("ORDER_PROCESSED", "Express order processed successfully. Total: %s".formatted(totalAmount));
        } else {
            notifyObservers("ORDER_FAILED", "Express order payment failed.");
        }
    }

    @Override
    public List<OrderItem> getItems() {
        return items;
    }

    @Override
    public String getDeliveryType() {
        return "Express Delivery";
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
