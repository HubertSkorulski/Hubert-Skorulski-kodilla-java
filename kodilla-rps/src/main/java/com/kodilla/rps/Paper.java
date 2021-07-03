package com.kodilla.rps;

public class Paper implements Figure{

    public char playerWin(ComputerFigure figure){
        if (figure.getName() == "scissors") {
            return 'L';
        } else if (figure.getName()=="rock"){
            return 'W';
        } else {
            return 'D';
        }
    }
    public String getName(){
        return "paper";
    }
}
