package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTestSuite {

    @Test
    void BasicPizzaCostTest() {
        //Given
        PizzaOrder thePizza = new BasicPizza();
        //When
        BigDecimal basicPizzaCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(15),basicPizzaCost);
    }

    @Test
    void BasicPizzaDescriptionTest() {
        //Given
        PizzaOrder thePizza = new BasicPizza();
        //When
        String basicPizzaDesc = thePizza.getDescription();
        //Then
        assertEquals("Basic pizza with tomato sauce and cheese",basicPizzaDesc);
    }

    @Test
    void BasicPizzaWithPineappleCostTest() {
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new PineappleDecorator(thePizza);
        //When
        BigDecimal basicPizzaCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(17),basicPizzaCost);
    }

    @Test
    void BasicPizzaWithPineappleDescriptionTest() {
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new PineappleDecorator(thePizza);
        //When
        String basicPizzaDesc = thePizza.getDescription();
        //Then
        assertEquals("Basic pizza with tomato sauce and cheese with pineapple",basicPizzaDesc);
    }

    @Test
    void BasicPizzaWithPineappleAndExtraSauceCostTest() {
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new PineappleDecorator(thePizza);
        thePizza = new ExtraSauceDecorator(thePizza);
        //When
        BigDecimal basicPizzaCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(20),basicPizzaCost);
    }

    @Test
    void BasicPizzaWithPineappleAndExtraSauceDescriptionTest() {
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new PineappleDecorator(thePizza);
        thePizza = new ExtraSauceDecorator(thePizza);
        //When
        String basicPizzaDesc = thePizza.getDescription();
        //Then
        assertEquals("Basic pizza with tomato sauce and cheese with pineapple with extra sauce",basicPizzaDesc);
    }
}
