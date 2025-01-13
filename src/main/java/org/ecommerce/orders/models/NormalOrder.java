package org.ecommerce.orders.models;

import org.ecommerce.payments.IPayment;
import org.ecommerce.products.IProduct;

import java.util.ArrayList;
import java.util.List;

public class NormalOrder implements IOrder {
    private final List<OrderItem> items;


    public NormalOrder() {
        this.items = new ArrayList<>();
    }

    @Override
    public void addItem(IProduct product, int quantity) {
        items.add(new OrderItem(product, quantity));
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
            System.out.printf("Normal order processed successfully! Total: %.2f%n", totalAmount);
        } else {
            System.out.println("Payment failed. Normal order not processed.");
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
}