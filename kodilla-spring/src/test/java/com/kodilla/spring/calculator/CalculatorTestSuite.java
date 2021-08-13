package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorTestSuite {

    @Autowired
    private Calculator calculator;

    @Test
    public void testCalculations() {
        //given
        double a = 4;
        double b = 3;
        //when
        double add = calculator.add(a,b);
        double sub = calculator.sub(a,b);
        double mul = calculator.mul(a,b);
        double div = calculator.div(a,b);

        //then
        assertEquals(7,add);
        assertEquals(1,sub);
        assertEquals(12,mul);
        assertEquals(1.333,div,0.001);
    }
}
