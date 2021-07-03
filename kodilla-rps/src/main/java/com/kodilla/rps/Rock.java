package com.kodilla.rps;

public class Rock implements Figure {

    public char playerWin(ComputerFigure figure){
        if (figure.getName() == "paper") {
            return 'L';
        } else if (figure.getName()== "scissors"){
            return 'W';
        } else {
            return 'D';
        }
    }

    public String getName(){
        return "rock";
    }
}
