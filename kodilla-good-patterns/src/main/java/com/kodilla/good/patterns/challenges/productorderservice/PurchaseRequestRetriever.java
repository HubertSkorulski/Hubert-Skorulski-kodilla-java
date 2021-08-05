package com.kodilla.good.patterns.challenges.productorderservice;

public class PurchaseRequestRetriever {

    public PurchaseRequest retrieve() {
        User user = new User("Hub","Nowak");
        String productName = "Product One";
        double price = 200.00;

        return new PurchaseRequest(user,productName,price);
    }

}
