package org.ecommerce.shipping;

import org.ecommerce.products.IProduct;

public class RegularShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(IProduct product) {
        return 20.00;
    }
}
