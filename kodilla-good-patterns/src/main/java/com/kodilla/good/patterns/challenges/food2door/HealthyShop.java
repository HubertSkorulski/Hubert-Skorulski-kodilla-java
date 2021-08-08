package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop implements Supplier {

    @Override
    public OrderSummary process(Product product) {
        if (product.isHealthy()) {
            System.out.println("Everything is correct");
            return new OrderSummary(product,true);
        } else {
            System.out.println("You have to order healthy product");
            return new OrderSummary(product,false);
        }
    }

    @Override
    public String getName() {
        return "Healthy Shop";
    }
}
