package com.kodilla.good.patterns.challenges.productorderservice;

public class BookPurchaseRepository implements PurchaseRepository {
    private User user;
    private String productName;

    public BookPurchaseRepository(User user, String productName, double price) {
        this.user = user;
        this.productName = productName;
        this.price = price;
    }

    private double price;

    @Override
    public void createPurchase (User user, String productName, double price) {
        System.out.println("Adding Book purchase: " + user.getName() + "/" + user.getSurname() + "/" + productName + "/" +price);
    }

}
