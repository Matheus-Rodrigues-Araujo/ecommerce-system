package org.ecommerce.payments;

public interface IPayment {
    boolean payment(int amount);

    void proccessPayment();
}
