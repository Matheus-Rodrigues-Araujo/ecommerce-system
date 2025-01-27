package org.ecommerce.payments.strategies;

import java.util.Scanner;

import org.ecommerce.payments.IPayment;
import org.ecommerce.payments.CreditCard;

public class CreditCardPayment implements IPayment {
    private CreditCard creditCard;

    public CreditCardPayment(CreditCard creditCard) {
        if (creditCard == null) throw new IllegalArgumentException("CreditCard instance not found!");
        this.creditCard = creditCard;
    }

    @Override
    public boolean payment(double amount) {
        System.out.println(">> Credit Card Payment <<");
        System.out.printf("Processing payment of %s ...".formatted(amount));
        if (creditCard.getAmount() < amount) throw new Error("Cannot pay due to your CreditCard amount");

        creditCard.setAmount(creditCard.getAmount() - amount);
        System.out.println();
        System.out.println("Payment Successful!");

        return true;
    }

    @Override
    public void proccessPayment() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("------------------------");
            System.out.println("> Credit Card Payment");
            System.out.println();

            System.out.println("Enter your credentials");
            String number = sc.nextLine();
            String date = sc.nextLine();
            String cvv = sc.nextLine();
            System.out.println();

            if (creditCard.verify(number, date, cvv)) {
                System.out.println(">>> Card accepted!");
            } else {
                throw new Error("> Invalid credentials");
            }
        } catch (Error ex) {
            throw new Error("> Payment denied: Invalid credentials");
        }
    }
}
