package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {
        int player_wins = 0;
        int comp_wins = 0;
        Figure playerFigure = null;
        boolean end = false;

        //Wprowadzenie imienia i rund
        Player player = new Player();
        player.setName();
        int rounds = player.setWinningRounds();

        while (!end) {
            System.out.println("Rounds: " + rounds);
            System.out.println("Player wins: " + player_wins);
            System.out.println("Computer wins: " + comp_wins);

            //Decyzja gracza
            String playerDecision = player.playerDecision();

            if (playerDecision.equals("1") || playerDecision.equals("2") || playerDecision.equals("3")) {
                playerFigure = player.playerFigure(playerDecision);

            } else if (playerDecision.equals("N")) {
                String playerConfirmation = player.confirmation();
                if (playerConfirmation.equals("Y")) {
                    player.setName();
                    rounds = player.setWinningRounds();
                    player_wins = 0;
                    comp_wins = 0;
                    continue;

                } else if (playerConfirmation.equals("N")) {
                    continue;
                }

            } else if (playerDecision.equals("X")) {
                String playerConfirmation2 = player.confirmation2();
                if (playerConfirmation2.equals("Y")) {
                    System.out.println("Player " + player_wins + ":" + comp_wins + " Computer");
                    System.out.println("Thanks for playing!");
                    break;
                } else if (playerConfirmation2.equals("N")) {
                    continue;
                }

            } else {
                continue;
            }
                //Figura komputera
            ComputerFigure computerFigure = new ComputerFigure();

            //Pojedynek
            String result = playerFigure.playerWin(computerFigure);
            //Liczenie punktów
            if (result.equals("W")) {
                player_wins++;
            } else if (result.equals("L")) {
                comp_wins++;
            } else if (result.equals("D")) {
            }
                //Koniec gry
            if (player_wins == rounds || comp_wins == rounds) {

                if (player_wins == rounds) {
                    end = true;
                    System.out.println("Player win " + player_wins + ":" + comp_wins);
                } else if (comp_wins == rounds) {
                    end = true;
                    System.out.println("Computer win " + comp_wins + ":" +player_wins);
                }
                String playAgain = player.askPlayAgain();
                if (playAgain.equals("N")) {
                    player.setName();
                    rounds = player.setWinningRounds();
                    player_wins = 0;
                    comp_wins = 0;
                    end = false;
                } else if (playAgain.equals("X")) {
                    System.out.println("Thanks for playing!");
                    end = true;
                }
            }
        }
    }
}

