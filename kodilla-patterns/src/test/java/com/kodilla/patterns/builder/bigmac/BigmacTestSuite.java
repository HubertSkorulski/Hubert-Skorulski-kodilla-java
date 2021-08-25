package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        BigMac bigMac = new BigMac.BigMacBuilder()
                .ingredient("Becon")
                .ingredient("Onion")
                .ingredient("Cucumber")
                .sauce("BBQ")
                .bun("with sesame")
                .burgers(3)
                .bigMac();
        //When
        int burgers = bigMac.getBurgers();
        int ingredients = bigMac.getIngredients().size();
        //Then
        assertEquals(3,burgers);
        assertEquals(3,ingredients);
        assertEquals("BBQ",bigMac.getSauce());
        System.out.println(bigMac);
    }
}
