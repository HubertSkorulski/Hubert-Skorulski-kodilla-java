package com.kodilla.rps;

import java.util.Random;

public class ComputerFigure {

    public static Figure getComputerFigure() {

        Random random = new Random();
        int comp_digit = random.nextInt(3) + 1;
        Figure com_figure = null;

        if (comp_digit == 1) {
            com_figure = new Rock();
        } else if (comp_digit == 2) {
            com_figure = new Paper();
        } else {
            com_figure = new Scissors();
        }
        return com_figure;
    }

    public String getName () {
        return getComputerFigure().getName();
    }
}
