package com.kodilla.good.patterns.challenges.food2door;

public class Bread implements Product {

    @Override
    public String getName() {
        return "Bread";
    }

    @Override
    public double price() {
        return 31.99;
    }

    @Override
    public boolean hasGluten() {
        return false;
    }

    @Override
    public boolean isHealthy() {
        return true;
    }


}
