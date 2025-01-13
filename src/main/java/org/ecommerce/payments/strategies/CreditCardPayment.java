package org.ecommerce.payments.strategies;

import org.ecommerce.payments.IPayment;
import org.ecommerce.payments.CreditCard;

import java.util.Scanner;

public class CreditCardPayment implements IPayment {
    private CreditCard card;

    @Override
    public boolean payment(int amount) {
        if (exinstingCard()) {
            System.out.println(">> Credit Card Payment <<");
            System.out.printf("Paying  %d%n", amount);
            card.setAmount(card.getAmount() - amount);
            return true;
        }
        return false;
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

            card = new CreditCard(number, date, cvv);
            System.out.println(">>> Card accepted!");

        } catch (Error ex) {
            throw new Error("Invalid Credentials");
        }
    }

    private boolean exinstingCard() {
        return card != null;
    }
}
