package org.ecommerce.orders.models;

import org.ecommerce.products.IProduct;

public class OrderItem {
    private final IProduct product;
    private final int quantity;

    public OrderItem(IProduct product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public IProduct getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("OrderItem{product=%s, quantity=%d}", product, quantity);
    }
}
