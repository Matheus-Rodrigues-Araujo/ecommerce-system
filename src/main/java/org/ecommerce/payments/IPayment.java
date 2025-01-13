package org.ecommerce.payments;

public interface IPayment {
    boolean payment(double amount);

    void proccessPayment();
}
