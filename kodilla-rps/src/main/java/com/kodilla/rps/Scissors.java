package com.kodilla.rps;

public class Scissors implements Figure {
    public char playerWin(ComputerFigure figure){
        if (figure.getName() == "rock") {
            return 'L';
        } else if (figure.getName()=="paper"){
            return 'W';
        } else {
            return 'D';
        }
    }


    public String getName(){
        return "scissors";
    }
}
