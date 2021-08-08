package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop implements Supplier {

    @Override
    public OrderSummary process(Product product) {
        if (product.price() > 2) {
            System.out.println("Everything is correct");
            return new OrderSummary(product,true);
        } else {
            System.out.println("You have to order more expensive thing");
            return new OrderSummary(product,false);
        }
    }

    @Override
    public String getName() {
        return "Extra Food Shop";
    }
}
