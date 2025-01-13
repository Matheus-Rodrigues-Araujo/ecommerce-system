package org.ecommerce.products;

import java.util.Objects;

public class Product implements IProduct {
    private final String name;
    protected final double price;

    public Product(String name, double price) {
        this.name = Objects.requireNonNull(name, "Product name cannot be null");
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='%s', price=%s}".formatted(name, price);
    }
}
