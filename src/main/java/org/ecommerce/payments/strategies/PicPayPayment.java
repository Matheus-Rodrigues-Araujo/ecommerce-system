package org.ecommerce.payments.strategies;

import org.ecommerce.payments.IPayment;
import org.ecommerce.payments.PicPay;

import java.util.Scanner;

public class PicPayPayment implements IPayment {
    private PicPay picPay;

    @Override
    public boolean payment(int amount) {
        System.out.println(">> PicPay Payment <<");

        System.out.printf("Processing payment of  %d%n ...", amount);

        if (picPay.getAmount() <= amount) {
            throw new Error("Cannot pay due to your picpay amount");
        }
        picPay.setAmount(picPay.getAmount() - amount);
        return true;
    }

    @Override
    public void proccessPayment() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("------------------------");
            System.out.println("> PicPay Payment");
            System.out.println();

            System.out.println("Enter your credentials");
            System.out.println();
            String email = sc.nextLine();
            String password = sc.nextLine();
            System.out.println();

            if (picPay.verify(email, password)) {
                System.out.println("Valid Data!");
            } else {
                System.out.println("Access denied!");
            }

        } catch (Error ex) {
            throw new Error("Invalid Credentials");
        }
    }


}


