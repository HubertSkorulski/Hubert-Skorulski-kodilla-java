import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SudokuGame {

    public void processingSudoku(){

        Board board = new Board();
        SudokuSolver sudokuSolver = new SudokuSolver(board);
        int tries = 0;
        List<BeforeGuessing> states = new ArrayList<>();

        sudokuSolver.exampleParameters();
        board.setDigit();
        if (sudokuSolver.correctBoard()) {
            while (board.emptyElements() != 0) {

                sudokuSolver.prepareValuesInElements();
                boolean solved = sudokuSolver.settingOccurred();

                if (!solved) {
                    tries ++;
                } else {
                    tries = 0;
                }

                if (tries > 2) {
                    BeforeGuessing beforeGuessing = new BeforeGuessing();
                    try {
                        Board copiedBoard = board.deepCopy();
                        beforeGuessing.setBoard(copiedBoard);
                    } catch (CloneNotSupportedException e) {
                        System.out.println("Deep copy not executed correctly");
                    }
                    SudokuElement guessedElement = sudokuSolver.guessTheValue();

                    if (guessedElement != null && sudokuSolver.valid()) {
                        if (states.size() > 0) {
                            String coordinates1 = board.findElement(guessedElement);
                            String coordinates2 = states.get(states.size()-1).getCoordinates();
                            if (!coordinates1.equals(coordinates2)) {
                                states.add(beforeGuessing);
                                beforeGuessing.setGuessedElement(guessedElement);
                                beforeGuessing.setCoordinates(board.findElement(guessedElement));
                            }
                        } else {
                            beforeGuessing.setGuessedElement(guessedElement);
                            beforeGuessing.setCoordinates(board.findElement(guessedElement));
                            states.add(beforeGuessing);
                        }
                        tries = 0;
                    } else {
                        BeforeGuessing previousState = states.get(states.size()-1);
                        board = sudokuSolver.setPreviousState(previousState);
                        sudokuSolver.setBoard(board);
                        if (!sudokuSolver.valid()) {
                            int index = states.indexOf(previousState);
                            previousState = states.get(index -1);
                            board = sudokuSolver.setPreviousState(previousState);
                            sudokuSolver.setBoard(board);
                            states.remove(index);
                        }
                    }
                }
            }
        } else {
            System.out.println("Board not correct");
        }

        System.out.println(board);
    }

    public boolean resolveSudoku() {
        boolean correctAnswer = false;
        boolean gameFinished = false;

        processingSudoku();
        Scanner scan = new Scanner(System.in);

        while (!correctAnswer) {
            System.out.println("Wanna play again? Yes or No?");
            String answer = scan.nextLine();
            if (answer.toUpperCase().equals("YES")) {
                correctAnswer = true;
                gameFinished = false;
            } else if (answer.toUpperCase().equals("NO")) {
                System.out.println("Thanks for playing");
                correctAnswer = true;
                gameFinished = true;
            } else {
                System.out.println("I don't understand your answer");
            }
        }

    return gameFinished;
    }

}

