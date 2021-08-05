package com.kodilla.good.patterns.challenges.productorderservice;

public interface PurchaseRepository {
    void createPurchase(User user, String productName, double price);
}
