package com.kodilla.testing.shape;

public class Triangle implements Shape {

    String shapeName;
    double field;

    public Triangle(String shapeName, double field) {
        this.shapeName = shapeName;
        this.field = field;
    }
    public String getShapeName () {
        return shapeName;
    }

    public double getField() {
        return field;
    }
}
