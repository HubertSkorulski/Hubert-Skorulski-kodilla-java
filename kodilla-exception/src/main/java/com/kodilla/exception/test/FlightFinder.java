package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {


    public boolean findFlight(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flightPossibility = new HashMap<String,Boolean>();
        flightPossibility.put("Modlin",true);
        flightPossibility.put("Okęcie",true);

        if (flightPossibility.containsKey(flight.getArrivalAirport()) && flightPossibility.containsKey(flight.getDepartureAirport())) {
            return (flightPossibility.get(flight.getArrivalAirport())) && flightPossibility.get(flight.getDepartureAirport());
        } else {
            throw new RouteNotFoundException();
        }

    }
}
