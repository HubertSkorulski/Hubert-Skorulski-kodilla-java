package com.kodilla.good.patterns.challenges.food2door;

public class Order {

    private Supplier supplier;
    private Product product;

    public Order(final Supplier supplier, final Product product) {
        this.supplier = supplier;
        this.product = product;
    }

    public void orderProcess() {
        OrderSummary orderSummary = supplier.process(product);

        if (orderSummary.isSucceed()) {
            System.out.println("Order executed by: " + supplier.getName());
            System.out.println("Ordered product: " + orderSummary.getProduct().getName() + " at a price: " + product.price());

        } else {
            System.out.println("Unsuccessful order execution: " + supplier.getName());
        }



    }
}
