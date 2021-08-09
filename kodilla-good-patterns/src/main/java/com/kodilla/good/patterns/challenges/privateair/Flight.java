package com.kodilla.good.patterns.challenges.privateair;

import java.time.LocalDate;

public class Flight {
    private String from;
    private String to;
    private LocalDate date;

    public Flight(String from, String to, LocalDate date) {
        this.from = from;
        this.to = to;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (!from.equals(flight.from)) return false;
        if (!to.equals(flight.to)) return false;
        return date.equals(flight.date);
    }

    @Override
    public int hashCode() {
        return date.hashCode();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date +
                '}';
    }
}
