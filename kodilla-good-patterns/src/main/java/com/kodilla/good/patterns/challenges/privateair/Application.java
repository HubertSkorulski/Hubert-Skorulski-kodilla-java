package com.kodilla.good.patterns.challenges.privateair;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        FlightRepository flightRepository = new FlightRepository();
        flightRepository.createFlight(new Flight("Białystok","Warszawa",(LocalDate.of(2021,10,5))));
        flightRepository.createFlight(new Flight("Warszawa","Chicago",(LocalDate.of(2021,11,5))));
        flightRepository.createFlight(new Flight("Chicago","Kraków",(LocalDate.of(2021,12,5))));
        flightRepository.createFlight(new Flight("Warszawa","Kraków",(LocalDate.of(2021,8,5))));
        flightRepository.createFlight(new Flight("Warszawa","Białystok",(LocalDate.of(2020,10,5))));
        flightRepository.createFlight(new Flight("Kraków","Warszawa",(LocalDate.of(2020,8,5))));
        flightRepository.createFlight(new Flight("Białystok","Warszawa",(LocalDate.of(2019,10,5))));
        flightRepository.createFlight(new Flight("Warszawa","Chicago",(LocalDate.of(2021,10,5))));
        flightRepository.createFlight(new Flight("Warszawa","Chicago",(LocalDate.of(2021,9,5))));
        flightRepository.createFlight(new Flight("Warszawa","Chicago",(LocalDate.of(2021,8,5))));

        FlightScanner flightScanner = new FlightScanner(flightRepository.getFlights());

        flightScanner.flightFromToVia("Białystok","Chicago","Warszawa");

    }
}
