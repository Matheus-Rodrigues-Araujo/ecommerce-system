package org.ecommerce.payments;

public class PicPay {

    private double amount;
    private String email;
    private String password;
    private boolean signedIn;


    public PicPay(String email, String password) {
        this.amount = 8000;
        this.email = email;
        this.password = password;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }

    public boolean verify(String inputEmail, String inputPassword) {
        boolean isValidUser = email.equals(inputEmail) && password.equals(inputPassword);
        if (isValidUser) {
            setSignedIn(true);
            return true;
        }
        return false;
    }

}
