package org.ecommerce;

import org.ecommerce.clients.Client;
import org.ecommerce.orders.factories.OrderFactory;
import org.ecommerce.orders.models.IOrder;
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

        Client client = new Client("John", "Doe", "johndoe@gmail.com", "87654321");

        // Decorator
        IProduct product1 = new Product("Mesa Pro Gamer", 2950.00);
        IProduct product2 = new DiscountedProduct(new Product("Berserk Vol.1", 90.00), 0.15);
        System.out.printf("> %s added new item: %s%n", client.getFirstName(), product1);
        System.out.printf("> %s added new item: %s%n", client.getFirstName(), product2);

        // Factory
        System.out.println("------------------------");
        IOrder order = OrderFactory.createOrder("express");
        order.addItem(product1, 1);
        order.addItem(product2, 2);
        System.out.printf("> Delivery Type: %s%n", order.getDeliveryType());
        System.out.printf("> Items in the Order: %s%n", order.getItems());
        System.out.printf("> Total Order Amount: %s%n", order.calculateTotal());

        // Strategy
        CreditCard creditCard = new CreditCard("1234", "09/10/2099", "000");
        PicPay picPay = new PicPay(client.getEmail(), "crazyHash123!");

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