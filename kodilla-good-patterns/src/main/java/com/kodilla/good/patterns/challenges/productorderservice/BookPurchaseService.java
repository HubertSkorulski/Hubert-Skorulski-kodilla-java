package com.kodilla.good.patterns.challenges.productorderservice;

public class BookPurchaseService implements PurchaseService {

    @Override
    public boolean purchase(User user, String productName, double price) {
        if (price > 100) {
            return  true;
        } else {
            return false;
        }
    }

}
