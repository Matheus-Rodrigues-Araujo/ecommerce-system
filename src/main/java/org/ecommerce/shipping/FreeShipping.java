package org.ecommerce.shipping;

import org.ecommerce.products.IProduct;

public class FreeShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(IProduct product) {
        return 0;
    }
}
