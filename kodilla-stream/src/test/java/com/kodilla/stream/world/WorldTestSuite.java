package com.kodilla.stream.world;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    void testGetSandBeansQuantity() {
        //Given
        Continent southAmerica = new Continent();
        Continent europe = new Continent();
        Country poland = new Country(new BigDecimal("210000000000000000000"));
        Country germany = new Country(new BigDecimal("310000000000000000000"));
        Country uruguay = new Country(new BigDecimal("410000000000000000000"));
        Country rpa = new Country(new BigDecimal("510000000000000000000"));
        //When
        southAmerica.addCountry(uruguay);
        southAmerica.addCountry(rpa);
        europe.addCountry(poland);
        europe.addCountry(germany);
        World world = new World();
        world.addContinent(southAmerica);
        world.addContinent(europe);
        //Then
        BigDecimal people = world.getPeopleQuantity();
        System.out.println(people);
    }
}
