package org.ecommerce.shipping;

import org.ecommerce.products.IProduct;

public interface ShippingStrategy {
    double calculateShippingCost(IProduct product);
}
