package com.kodilla.rps;
import java.io.IOException;
import java.util.Scanner;

public class Player {

    public String setName() {
        String userName;
        Scanner name = new Scanner(System.in);
        System.out.println("Enter username");
        userName = name.nextLine();
        System.out.println("Player name is: " + userName);
        return userName;
    }

    public int setWinningRounds() {
        int winningRounds = 0;
        boolean correct = false;
        Scanner rounds = new Scanner(System.in);
        System.out.println("How many wins do we play to?");
        //
        while (!correct) {
            try {
                winningRounds = Integer.parseInt(rounds.nextLine());
                correct = true;
            } catch (Exception e) {
                System.out.println("Input a number");
                continue;
            }
        }
        return winningRounds;
    }

    public String playerDecision() {
        Scanner decision = new Scanner(System.in);
        System.out.println("Press: \n1 - Rock\n" + "2 - Paper\n" + "3 - Scissors\n" +
                "X - Quit\n" +
                "N - Restart\nWhat is your decision?");
        String playerDecision = decision.nextLine().toUpperCase();
        return playerDecision;
    }

    public String askPlayAgain() {
        Scanner decision = new Scanner(System.in);
        System.out.println("Do you want to play again?\nIf yes, input N, if no - X");
        String playerDecision = decision.nextLine().toUpperCase();;
        while (!(playerDecision.equals("N")) && !(playerDecision.equals("X"))) {
            System.out.println("N if you want play again, X if you want to quit");
            playerDecision = decision.nextLine().toUpperCase();
        }
        return playerDecision;
    }


    public Figure playerFigure (String playerDecision) {
        Figure playerFigure = null;

        if (playerDecision.equals("1")) {
            playerFigure = new Rock();
        } else if (playerDecision.equals("2")) {
            playerFigure = new Paper();
        } else if (playerDecision.equals("3")) {
            playerFigure = new Scissors();
        }
        return playerFigure;
    }

    public String confirmation() {
        String confirmation;
        Boolean correct = false;
        Scanner confirm = new Scanner(System.in);

        System.out.println("Are you sure you want restart the game? If yes, input Y, if no, input N");
        confirmation = confirm.nextLine().toUpperCase();
        while (!correct) {
            if (confirmation.toUpperCase().equals("N") || confirmation.toUpperCase().equals("Y")) {
                correct = true;
            }
        }
        return confirmation;
    }

    public String confirmation2() {
        String confirmation;
        Boolean correct = false;
        Scanner confirm = new Scanner(System.in);

        System.out.println("Are you sure you want quit the game? If yes, input Y, if no, input N");
        confirmation = confirm.nextLine().toUpperCase();
        while (!correct) {
            if (confirmation.toUpperCase().equals("N") || confirmation.toUpperCase().equals("Y")) {
                correct = true;
            }
        }
        return confirmation;
    }

}
