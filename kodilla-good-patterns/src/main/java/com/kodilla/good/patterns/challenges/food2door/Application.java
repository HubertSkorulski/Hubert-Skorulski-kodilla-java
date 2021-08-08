package com.kodilla.good.patterns.challenges.food2door;

public class Application {

    public static void main(String[] args) {
        Supplier extraFoodShop = new HealthyShop();
        Product bread = new Bread();
        Order firstOrder = new Order(extraFoodShop,bread);

        firstOrder.orderProcess();
    }




}
