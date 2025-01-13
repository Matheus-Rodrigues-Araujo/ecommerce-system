package org.ecommerce.products;

public class DiscountedProduct extends ProductModifier {
    private final double discount;

    public DiscountedProduct(IProduct product, double discount) {
        super(product);
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("Discount must be between 0 and 1 (0% and 100%)");
        }
        this.discount = discount;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public double getDiscount() {
        return discount;
    }

    public Double applyPriceDiscount(double price) {
        return super.getPrice() * (1 - discount);
    }

    @Override
    public String toString() {
        return String.format(
                "DiscountedProduct{name='%s', discountedPrice=%.2f, price=%.2f, discount=%.2f}",
                super.getName(),
                applyPriceDiscount(super.getPrice()),
                super.getPrice(),
                discount
        );
    }

}
