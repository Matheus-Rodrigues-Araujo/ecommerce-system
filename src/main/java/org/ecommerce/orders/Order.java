package org.ecommerce.orders;

import org.ecommerce.payments.IPayment;
import org.ecommerce.products.IProduct;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private final String id;
    private double total = 0;
    private final List<OrderItem> items;
    private boolean isClosed;

    public Order() {
        this.id = UUID.randomUUID().toString();
        this.total = 0.0;
        this.items = new ArrayList<>();
        this.isClosed = false;
    }

    public void proccessOrder(IPayment payment) {
        payment.proccessPayment();
    }

    public void addItem(IProduct product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Error: Quantity is empty!");
        }
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
        recalculateTotal();
    }

    private void recalculateTotal() {
        this.total = this.items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setClosed() {
        this.isClosed = true;
    }

    public boolean isClosed() {
        return isClosed;
    }

}
