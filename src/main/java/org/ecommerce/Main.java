package org.ecommerce;

import org.ecommerce.clients.Client;
import org.ecommerce.orders.factories.OrderFactory;
import org.ecommerce.orders.models.IOrder;
import org.ecommerce.orders.observers.CustomerNotifier;
import org.ecommerce.orders.observers.OrderLogger;
import org.ecommerce.payments.CreditCard;
import org.ecommerce.payments.IPayment;
import org.ecommerce.payments.PicPay;
import org.ecommerce.payments.strategies.CreditCardPayment;
import org.ecommerce.payments.strategies.PicPayPayment;
import org.ecommerce.products.DiscountedProduct;
import org.ecommerce.products.IProduct;
import org.ecommerce.products.Product;

public class Main {
    private static IPayment payment;
    private static final int paymentMethod = 1;

    public static void main(String[] args) {

        Client client = new Client("John", "Doe", "john@gmail.com", "87654321");

        // Decorator
        IProduct product1 = new Product("Mesa Pro Gamer", 2950.00);
        IProduct product2 = new DiscountedProduct(new Product("Berserk Vol.1", 90.00), 0.3);
        IProduct product3 = new DiscountedProduct(new Product("Violão", 800.00), 0.08);
        // Factory
        System.out.println("------------------------");
        IOrder order = OrderFactory.createOrder("express");

        // Observer
        order.addObserver(new OrderLogger());
        order.addObserver(new CustomerNotifier());

        order.addItem(product1, 1);
        order.addItem(product2, 2);
        order.addItem(product3, 3);

        // Strategy
        CreditCard creditCard = new CreditCard("1234", "09/10/2099", "000");
        PicPay picPay = new PicPay(client.getEmail(), "1234");

        switch (paymentMethod) {
            case 1:
                payment = new PicPayPayment(picPay);
                break;
            case 2:
                payment = new CreditCardPayment(creditCard);
                break;
        }

        order.proccessOrder(payment);
    }
}