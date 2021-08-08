package com.kodilla.good.patterns.challenges.food2door;

public interface Supplier {
    OrderSummary process(Product product);
    String getName();
}
