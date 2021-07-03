package com.kodilla.rps;

public class Rock implements Figure {

    public String playerWin(ComputerFigure figure){
        if (figure.getName().equals("paper")) {
            System.out.println("Computer win");
            return "L";
        } else if (figure.getName().equals("scissors")) {
            System.out.println("Player win");
            return "W";
        } else {
            System.out.println("It's a draw");
            return "D";
        }
    }

    public String getName(){
        return "rock";
    }
}
