package org.ecommerce.payments;

public class CreditCard {

    private double amount;
    private final String number;
    private final String date;
    private final String cvv;

    public CreditCard(String number, String date, String cvv) {
        this.amount = 5500;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    public boolean verify(String inputNumber, String inputDate, String inputCvv) {
        return number.equals(inputNumber) && date.equals(inputDate) && cvv.equals(inputCvv);
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

}
