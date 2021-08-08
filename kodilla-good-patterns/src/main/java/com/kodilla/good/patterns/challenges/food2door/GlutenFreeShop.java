package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop implements Supplier {
    @Override
    public OrderSummary process(Product product) {
        if (!product.hasGluten()) {
            System.out.println("Everything is correct");
            return new OrderSummary(product,true);
        } else {
            System.out.println("You can't order anything with gluten in our shop");
            return new OrderSummary(product,false);
        }
    }

    @Override
    public String getName() {
        return "Gluten Free Shop";
    }
}
