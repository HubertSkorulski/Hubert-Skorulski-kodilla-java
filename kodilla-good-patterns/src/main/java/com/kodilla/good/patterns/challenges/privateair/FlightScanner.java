package com.kodilla.good.patterns.challenges.privateair;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FlightScanner {

    private final HashSet<Flight> flights;

    public FlightScanner(HashSet<Flight> flights) {
        this.flights = flights;
    }

    public void flightFrom(String from) {

        flights.stream().filter(s -> s.getFrom().equals(from))
                .forEach(System.out::println);
    }

    public void flightTo(String to) {

        flights.stream().filter(s -> s.getTo().equals(to))
                .forEach(System.out::println);
    }

    public List<Flight> flightFromTo(String from, String to) {

        return flights.stream().filter(s -> s.getFrom().equals(from))
                .filter(s -> s.getTo().equals(to))
                .collect(Collectors.toList());
    }

    public void flightFromToVia(String from, String to, String via) {

        List<Flight> firstFlights = flights.stream()
                .filter(s -> s.getFrom().equals(from))
                .filter(s -> s.getTo().equals(via))
                .collect(Collectors.toList());
        List<Flight> secondaryFlights = flights.stream()
                .filter(s -> s.getFrom().equals(via))
                .filter(s-> s.getTo().equals(to))
                .collect(Collectors.toList());

        System.out.println(firstFlights.size());
        System.out.println(secondaryFlights.size());
        Map<Flight,Flight> flightsVia = new HashMap<>();

        for (Flight firstFlight : firstFlights) {
            for (Flight secondaryFlight : secondaryFlights) {
                flightsVia.put(firstFlight,secondaryFlight);
            }
        }

        for (Map.Entry<Flight,Flight> entry : flightsVia.entrySet()) {
            System.out.println("Flight from " + entry.getKey().getFrom() + " to " + entry.getValue().getTo() +  " via "
                    + entry.getValue().getFrom() + " is available");

        }
    }


}
