package org.ecommerce.orders.factories;

import org.ecommerce.orders.models.IOrder;
import org.ecommerce.orders.models.NormalOrder;
import org.ecommerce.orders.models.ExpressOrder;

public class OrderFactory {
    public static IOrder createOrder(String orderType) {
        if ("express".equalsIgnoreCase(orderType)) {
            return new ExpressOrder();
        } else if ("normal".equalsIgnoreCase(orderType)) {
            return new NormalOrder();
        } else {
            throw new IllegalArgumentException("Invalid order type: %s".formatted(orderType));
        }
    }
}
