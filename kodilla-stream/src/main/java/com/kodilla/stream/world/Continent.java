package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public class Continent {
    //private final String contName;
    private final Set<Country> countries = new HashSet<>();

    //public Continent(String contName) {
    //    this.contName = contName;
    //}

    public void addCountry (Country country) {
        countries.add(country);
    }
    public Set<Country> getCountries() {
        return countries;
    }
}
