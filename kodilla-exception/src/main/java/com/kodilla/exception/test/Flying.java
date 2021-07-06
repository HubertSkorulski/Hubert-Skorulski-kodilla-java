package com.kodilla.exception.test;

public class Flying {

    public static void main(String[] args) {
        Flight flight = new Flight("Modlin","Okęcie");
        FlightFinder flightFinder = new FlightFinder();

        try {
            System.out.println(flightFinder.findFlight(flight));
        } catch (RouteNotFoundException e) {
            System.out.println("Route not found");
        }

    }
}
