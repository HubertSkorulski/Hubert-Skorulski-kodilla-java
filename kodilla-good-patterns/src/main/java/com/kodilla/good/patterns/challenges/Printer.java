package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;


public class Printer {

    public static void main(String[] args) {

        System.out.println(MovieStore.getMovies().entrySet().stream()
                .flatMap(e -> e.getValue().stream())
                .collect(Collectors.joining("!")));


    }
}
