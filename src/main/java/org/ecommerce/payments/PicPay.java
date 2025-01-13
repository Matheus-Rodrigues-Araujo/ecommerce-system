package org.ecommerce.payments;

public class PicPay {

    private int amount;
    private String email;
    private String password;
    private boolean signedIn;


    public PicPay(String email, String password) {
        this.amount = 2800;
        this.email = email;
        this.password = password;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
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
