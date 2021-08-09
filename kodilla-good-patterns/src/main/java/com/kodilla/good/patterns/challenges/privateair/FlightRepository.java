package com.kodilla.good.patterns.challenges.privateair;

import java.util.HashSet;
import java.util.Set;

public class FlightRepository {
    HashSet<Flight> flights = new HashSet<>();

    public void createFlight(Flight flight) {
        flights.add(flight);
    }

    public HashSet<Flight> getFlights() {
        return flights;
    }
}
