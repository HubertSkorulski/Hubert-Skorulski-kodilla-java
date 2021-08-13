package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    public double add(double a, double b) {
        double val = a + b;
        return val;
    }
    public double sub(double a,double b) {
        double val = a - b;
        return val;
    }
    public double mul(double a, double b) {
        double val = a * b;
        return val;
    }
    public double div(double a, double b) {
        double val = a/b;
        return val;
    }
}
