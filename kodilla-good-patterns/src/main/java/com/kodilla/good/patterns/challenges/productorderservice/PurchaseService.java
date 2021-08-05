package com.kodilla.good.patterns.challenges.productorderservice;

public interface PurchaseService {

    public boolean purchase (User user, String productName, double price);

    public void inform (User user);

}
