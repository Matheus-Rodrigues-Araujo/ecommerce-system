package org.ecommerce.products;

public abstract class ProductModifier implements IProduct {
    private final IProduct wrappee;

    public ProductModifier(IProduct product) {
        this.wrappee = product;
    }

    @Override
    public String getName() {
        return wrappee.getName();
    }

    @Override
    public double getPrice() {
        return wrappee.getPrice();
    }

}
