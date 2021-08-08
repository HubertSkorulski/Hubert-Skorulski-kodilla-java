package com.kodilla.good.patterns.challenges.food2door;

public class OrderSummary {
    private Product product;
    private boolean orderSucceed;

    public OrderSummary(Product product, boolean orderSucceed) {
        this.product = product;
        this.orderSucceed = orderSucceed;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isSucceed() {
        return orderSucceed;
    }
}
