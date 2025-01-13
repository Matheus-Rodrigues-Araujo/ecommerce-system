package org.ecommerce.orders.models;

import org.ecommerce.payments.IPayment;
import org.ecommerce.products.IProduct;

import java.util.List;

public interface IOrder {
    void addItem(IProduct product, int quantity);

    void proccessOrder(IPayment payment);

    double calculateTotal();

    List<OrderItem> getItems();

    String getDeliveryType();
}
