package com.kodilla.good.patterns.challenges.productorderservice;

public class PurchaseSummary {
    public User user;
    public boolean bought;
    public String productName;

    public PurchaseSummary(User user, String productName, boolean bought) {
        this.user = user;
        this.bought = bought;
        this.productName = productName;
    }

    public User getUser() {
        return user;
    }

    public boolean isBought() {
        return bought;
    }

    public String getProductName() {
        return productName;
    }
}
