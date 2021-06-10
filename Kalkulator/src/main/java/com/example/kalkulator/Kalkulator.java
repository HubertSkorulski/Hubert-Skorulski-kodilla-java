package com.example.kalkulator;

public class Kalkulator {
    double a;
    double b;
    public Kalkulator(double a, double b) {
        this.a = a;
        this.b = b;
    }
    public void adding() {
        System.out.println(a + b);
    }
    public void substracting() {
        System.out.println(a - b);
    }

    public static void main(String args[]){
        Kalkulator kal1 = new Kalkulator(4,2.4);
        kal1.adding();
        kal1.substracting();
    }
}

