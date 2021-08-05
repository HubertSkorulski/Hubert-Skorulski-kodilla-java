package com.kodilla.good.patterns.challenges.productorderservice;


public class PurchaseRequest {
    private User user;
    private String productName;
    private double price;

    public PurchaseRequest(User user, String productName, double price) {
        this.user = user;
        this.productName = productName;
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}
