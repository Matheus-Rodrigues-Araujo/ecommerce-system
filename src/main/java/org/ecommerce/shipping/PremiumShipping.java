package org.ecommerce.shipping;
import org.ecommerce.products.IProduct;

public class PremiumShipping implements ShippingStrategy {
    @Override
    public double calculateShippingCost(IProduct product) {
        return 30;
    }
}
