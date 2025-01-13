package org.ecommerce;

import org.ecommerce.clients.Client;
import org.ecommerce.orders.Order;
import org.ecommerce.payments.CreditCard;
import org.ecommerce.payments.IPayment;
import org.ecommerce.payments.PicPay;
import org.ecommerce.payments.strategies.CreditCardPayment;
import org.ecommerce.payments.strategies.PicPayPayment;
import org.ecommerce.products.DiscountedProduct;
import org.ecommerce.products.IProduct;
import org.ecommerce.products.Product;

public class Main {
    private static final Order order = new Order();
    private static IPayment payment;
    private static final int paymentMethod = 1;

    public static void main(String[] args) {

        Client client = new Client("John", "Doe", "johndoe@gmail.com", "87654321");

        //Decorator
        IProduct product1 = new Product("Ps5", 4500.00);
        IProduct product2 = new DiscountedProduct(new Product("Berserk Vol.1", 120.00), 0.15);

        order.addItem(product1, 1);
        order.addItem(product2, 2);
        System.out.println(order.getItems());

        // Strategy
        CreditCard creditCard = new CreditCard("1234", "09/10/2099", "000");
        PicPay picPay = new PicPay(client.getEmail(), "crazyHash123!");

        switch (paymentMethod) {
            case 1:
                payment = new PicPayPayment();
                break;
            case 2:
                payment = new CreditCardPayment();
                break;
        }

        order.proccessOrder(payment);

    }
}