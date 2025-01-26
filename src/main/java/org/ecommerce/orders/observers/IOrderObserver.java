package org.ecommerce.orders.observers;

import org.ecommerce.orders.models.IOrder;

public interface IOrderObserver {
    void update(String event, String message);
}