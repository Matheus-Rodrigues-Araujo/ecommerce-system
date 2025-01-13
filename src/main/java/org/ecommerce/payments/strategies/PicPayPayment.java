package org.ecommerce.payments.strategies;

import org.ecommerce.payments.IPayment;
import org.ecommerce.payments.PicPay;

import java.util.Scanner;

public class PicPayPayment implements IPayment {
    private final PicPay picPay;

    public PicPayPayment(PicPay picPay) {
        if (picPay == null) throw new IllegalArgumentException("PicPay instance not found!");
        this.picPay = picPay;
    }

    @Override
    public boolean payment(double amount) {
        System.out.println("------------------------");
        System.out.println(">> PicPay Payment <<");
        System.out.printf("Processing payment of %s ...".formatted(amount));

        if (picPay.getAmount() < amount) throw new Error("Cannot pay due to your PicPay amount");

        picPay.setAmount(picPay.getAmount() - amount);
        System.out.println();
        System.out.println("Payment Successful!");

        return true;
    }

    @Override
    public void proccessPayment() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("------------------------");
            System.out.println("> PicPay");
            System.out.println();

            System.out.println("Enter your credentials");
            System.out.println();
            String email = sc.nextLine();
            String password = sc.nextLine();
            System.out.println();

            if (picPay.verify(email, password)) {
                System.out.println("Valid Data!");
            } else {
                throw new Error("> Invalid credentials");
            }

        } catch (Error ex) {
            throw new Error("Bad request");
        }
    }


}


