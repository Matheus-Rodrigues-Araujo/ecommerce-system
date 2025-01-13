package org.ecommerce.clients;

public class Client {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public Client(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Name=%s %s\nEmail=%s\nPhone=%s".formatted(getFirstName(), getLastName(), getEmail(), getPhone());
    }


}
