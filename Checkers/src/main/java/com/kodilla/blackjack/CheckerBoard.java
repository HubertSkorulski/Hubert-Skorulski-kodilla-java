package com.kodilla.blackjack;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckerBoard {

    private Image empty = new Image("file:src/main/resources/empty.png", 75, 75, false, true);
    TextField textFieldTo = new TextField();
    TextField textFieldFrom = new TextField();
    Label takePawn = new Label("Take pawn from");
    Label movePawnTo = new Label("Move pawn to");
    List<Pawn> redsList = new ArrayList<>();
    List<Pawn> bluesList = new ArrayList<>();
    Label redPoints = new Label("12");
    Label bluePoints = new Label("12");


    public void startingBoard(GridPane gridPane) {
        gridPane.setPrefSize(75, 75);
        gridPane.setMinWidth(75);
        gridPane.setMaxWidth(75);
        gridPane.setMaxHeight(75);
        gridPane.setMinHeight(75);

        redsList.clear();
        bluesList.clear();

        for (int i =0; i<12; i++) {
            redsList.add(new Pawn("red",false));
        }
        for (int i =0; i<12; i++) {
            bluesList.add(new Pawn("blue",false));
        }

        for (Pawn pawn : redsList){
            pawn.setNode();
        }
        for (Pawn pawn : bluesList) {
            pawn.setNode();
        }

        //Empties
        for (int i = 0; i < 10; i++) {
            gridPane.add(new ImageView(empty), i + 1, i);
        }
        for (int i = 2; i < 10; i = i + 2) {
            for (int k = 1; k < 9; k = k + 2) {
                gridPane.add(new ImageView(empty), i, k);
            }
        }
        for (int i = 3; i < 10; i = i + 2) {
            for (int k = 2; k < 10; k = k + 2) {
                gridPane.add(new ImageView(empty), i, k);
            }
        }
        gridPane.add(new ImageView(empty), 0, 0);
        //Blues
        gridPane.add(bluesList.get(0).getNode(),3,1);
        gridPane.add(bluesList.get(1).getNode(),5,1);
        gridPane.add(bluesList.get(2).getNode(),7,1);
        gridPane.add(bluesList.get(3).getNode(),9,1);
        gridPane.add(bluesList.get(4).getNode(),2,2);
        gridPane.add(bluesList.get(5).getNode(),4,2);
        gridPane.add(bluesList.get(6).getNode(),6,2);
        gridPane.add(bluesList.get(7).getNode(),8,2);
        gridPane.add(bluesList.get(8).getNode(),3,3);
        gridPane.add(bluesList.get(9).getNode(),5,3);
        gridPane.add(bluesList.get(10).getNode(),7,3);
        gridPane.add(bluesList.get(11).getNode(),9,3);

        //Reds
        gridPane.add(redsList.get(0).getNode(),2,6);
        gridPane.add(redsList.get(1).getNode(),4,6);
        gridPane.add(redsList.get(2).getNode(),6,6);
        gridPane.add(redsList.get(3).getNode(),8,6);
        gridPane.add(redsList.get(4).getNode(),3,7);
        gridPane.add(redsList.get(5).getNode(),5,7);
        gridPane.add(redsList.get(6).getNode(),7,7);
        gridPane.add(redsList.get(7).getNode(),9,7);
        gridPane.add(redsList.get(8).getNode(),2,8);
        gridPane.add(redsList.get(9).getNode(),4,8);
        gridPane.add(redsList.get(10).getNode(),6,8);
        gridPane.add(redsList.get(11).getNode(),8,8);

        gridPane.add(textFieldTo,11,5);
        gridPane.add(textFieldFrom,11,3);
        gridPane.add(takePawn, 11, 2);
        gridPane.add(movePawnTo, 11, 4);
        gridPane.add(redPoints,11,8);
        gridPane.add(bluePoints,11,1);

    }

    public void decorateTheBoard(GridPane gridPane){
        Label label1 = new Label("    A");
        Label label2 = new Label("    B");
        Label label3 = new Label("    C");
        Label label4 = new Label("    D");
        Label label5 = new Label("    E");
        Label label6 = new Label("    F");
        Label label7 = new Label("    G");
        Label label8 = new Label("    H");
        Label label9 = new Label("1");
        Label label10 = new Label("2");
        Label label11 = new Label("3");
        Label label12 = new Label("4");
        Label label13 = new Label("5");
        Label label14 = new Label("6");
        Label label15 = new Label("7");
        Label label16 = new Label("8");

        gridPane.add(label1, 2, 0);
        gridPane.add(label2, 3, 0);
        gridPane.add(label3, 4, 0);
        gridPane.add(label4, 5, 0);
        gridPane.add(label5, 6, 0);
        gridPane.add(label6, 7, 0);
        gridPane.add(label7, 8, 0);
        gridPane.add(label8, 9, 0);
        gridPane.add(label9, 10,1);
        gridPane.add(label10, 10, 2);
        gridPane.add(label11, 10, 3);
        gridPane.add(label12, 10, 4);
        gridPane.add(label13, 10, 5);
        gridPane.add(label14, 10, 6);
        gridPane.add(label15, 10, 7);
        gridPane.add(label16, 10, 8);

        List<Label> labelsHor = new LinkedList<>();
        List<Label> labelsVer = new LinkedList<>();
        labelsHor.add(label1);
        labelsHor.add(label2);
        labelsHor.add(label3);
        labelsHor.add(label4);
        labelsHor.add(label5);
        labelsHor.add(label6);
        labelsHor.add(label7);
        labelsHor.add(label8);
        labelsVer.add(label9);
        labelsVer.add(label10);
        labelsVer.add(label11);
        labelsVer.add(label12);
        labelsVer.add(label13);
        labelsVer.add(label14);
        labelsVer.add(label15);
        labelsVer.add(label16);



        for (Label label : labelsHor) {
            label.setFont(new Font("Arial",30));
            label.setTextFill(Color.web("#FFF"));
            label.setAlignment(Pos.CENTER);
        }
        for (Label label : labelsVer) {
            label.setFont(new Font("Arial",30));
            label.setTextFill(Color.web("#FFF"));
            label.setAlignment(Pos.CENTER);
        }


        //Decorating labels around checkerboard
        takePawn.setAlignment(Pos.BOTTOM_RIGHT);
        takePawn.setTextFill(Color.web("#FFF"));
        takePawn.setFont(new Font("Arial", 15));

        movePawnTo.setAlignment(Pos.BOTTOM_RIGHT);
        movePawnTo.setTextFill(Color.web("#FFF"));
        movePawnTo.setFont(new Font("Arial", 15));

        redPoints.setAlignment(Pos.BOTTOM_RIGHT);
        redPoints.setTextFill(Color.INDIANRED);
        redPoints.setFont(new Font("Arial", 40));

        bluePoints.setAlignment(Pos.BOTTOM_RIGHT);
        bluePoints.setTextFill(Color.CADETBLUE);
        bluePoints.setFont(new Font("Arial", 40));

    }

    public void cleaning (GridPane gridPane) {
        gridPane.getChildren().clear();
    }

    public void movePawn(GridPane gridPane, final int rowFrom, final int colFrom, int rowTo, int colTo) throws FileNotFoundException {
        /*Node movingNode = null;
        ObservableList<Node> children = gridPane.getChildren();
        Node newPlace = null;
        Node beatenNode = null;
        int checkingRow = 0;
        int checkingCol = 0;
        Pawn movingPawn = null;
        Pawn beatenPawn = null;


        for (Node node : children) {
            if (gridPane.getRowIndex(node) == rowFrom && gridPane.getColumnIndex(node) == colFrom) {
                movingNode = node;
                break;
            }
        }

        for (Node node : children) {
            if (gridPane.getRowIndex(node) == rowTo && gridPane.getColumnIndex(node) == colTo) {
                newPlace = node;
            }
        }
        //Tu sprawdzam czy na trasie jest pionek do zbicia
        for (int i = 1; i < Math.abs(rowTo - rowFrom); i++) {
            if (rowTo > rowFrom && colTo > colFrom) {
                checkingRow = rowFrom + i;
                checkingCol = colFrom + i;
            } else if (rowTo < rowFrom && colTo > colFrom) {
                checkingRow = rowFrom - i;
                checkingCol = colFrom + i;
            } else if (rowTo > rowFrom && colTo < colFrom) {
                checkingRow = rowFrom + i;
                checkingCol = colFrom - i;
            } else if (rowTo < rowFrom && colTo < colFrom) {
                checkingRow = rowFrom - i;
                checkingCol = colFrom - i;
            } else {
                System.out.println("Coś się zepsuło i nie było mnie słychać");
            }

            for (Node node : children) {
                if (gridPane.getRowIndex(node) == checkingRow && gridPane.getColumnIndex(node) == checkingCol) {
                    beatenNode = node;
                    break;
                }
            }

            if (beatenNode != null) {
                break;
            }
        }

        //Tu nody z gridPane zmieniamy na obiekty
        List<Pawn> allPawns = Stream.concat(redsList.stream(),bluesList.stream()).collect(Collectors.toList());
        for (Pawn pawn : allPawns) {
            if (pawn.getNode()==movingNode) {
                movingPawn = pawn;
                break;
            }
        }
        for (Pawn pawn : allPawns) {
            if (pawn.getNode() == beatenNode){
                beatenPawn = pawn;
                break;
            }
        }

        //Tu wykonywany jest ruch
        if (newPlace == null) {
            if (!Arrays.asList(0).contains(colTo) && (!Arrays.asList(0).contains(rowTo))) {
                if (movingPawn.isQueen()) { //ruch damki
                    if (Math.abs(rowTo-rowFrom) == Math.abs(colFrom-colTo)) {
                        if (beatenPawn != null) {
                            if (movingPawn.getColour() != beatenPawn.getColour()) { //ruch niebieskiej damki
                                //Pozycja po zbitym pionku
                                if (rowTo > rowFrom && colTo > colFrom) {
                                    rowTo = checkingRow + 1;
                                    colTo = checkingCol + 1;
                                } else if (rowTo < rowFrom && colTo > colFrom) {
                                    rowTo = checkingRow - 1;
                                    colTo = checkingCol + 1;
                                } else if (rowTo > rowFrom && colTo < colFrom) {
                                    rowTo = checkingRow + 1;
                                    colTo = checkingCol - 1;
                                } else if (rowTo < rowFrom && colTo < colFrom) {
                                    rowTo = checkingRow - 1;
                                    colTo = checkingCol - 1;
                                } else {
                                    System.out.println("Coś się zepsuło i nie było mnie słychać2");
                                }
                                for (Node node : children) {
                                    if (gridPane.getRowIndex(node) == rowTo && gridPane.getColumnIndex(node) == colTo) {
                                        newPlace = node;
                                    }
                                }
                                if (newPlace == null) {
                                    gridPane.getChildren().remove(beatenPawn.getNode());
                                    gridPane.getChildren().remove(movingPawn.getNode());
                                    gridPane.add(movingPawn.getNode(), colTo, rowTo);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Nie ma miejsca na Twoj pionek", "Tekst", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Chcesz zbic swojego", "Tekst", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            gridPane.getChildren().remove(movingPawn.getNode());
                            gridPane.add(movingPawn.getNode(), colTo, rowTo);
                        }
                    }
                } else { //zwykły pionek
                    if ((colTo == colFrom + 1) || (colTo == colFrom - 1)) {
                        if (movingPawn.getColour().equals("blue")) {
                            if (rowTo == rowFrom + 1) {
                                gridPane.getChildren().remove(movingPawn.getNode());
                                if (rowTo == 8){
                                    movingPawn.setQueen(true);
                                    movingPawn.setNode();
                                }
                                gridPane.add(movingPawn.getNode(),colTo,rowTo);
                            } else {

                                JOptionPane.showMessageDialog(null,"Nie cofaj","Tekst",JOptionPane.ERROR_MESSAGE);
                            }
                        } else if (movingPawn.getColour().equals("red")) {
                            if (rowTo == rowFrom - 1) {
                                gridPane.getChildren().remove(movingPawn.getNode());
                                if (rowTo == 1) {
                                    movingPawn.setQueen(true);
                                    movingPawn.setNode();
                                }
                                gridPane.add(movingPawn.getNode(),colTo,rowTo);
                            } else {
                                JOptionPane.showMessageDialog(null,"Nie cofaj","Tekst",JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            System.out.println("Nie rozpoznaję koloru pionka");
                        }

                    } else if ((colTo == colFrom + 2) || (colTo == colFrom - 2)) {
                        if (beatenPawn != null) {
                            if (rowTo == rowFrom + 2 || rowTo == rowFrom -2) {
                                if (!movingPawn.getColour().equals(beatenPawn.getColour())) {
                                    gridPane.getChildren().remove(beatenPawn.getNode());
                                    gridPane.getChildren().remove(movingPawn.getNode());
                                    if (movingPawn.getColour().equals("red")) {
                                        if (rowTo == 1) {
                                            movingPawn.setQueen(true);
                                            movingPawn.setNode();
                                        }
                                        gridPane.add(movingPawn.getNode(), colTo, rowTo);

                                    } else if (movingPawn.getColour().equals("blue")) {
                                        if (rowTo == 8) {
                                            movingPawn.setQueen(true);
                                            movingPawn.setNode();
                                        }
                                        gridPane.add(movingPawn.getNode(), colTo, rowTo);
                                    } else {
                                        System.out.println("Cos nie działa z kolorem ruszanego pionka");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null,"Bijesz swojego","Tekst",JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Za daleko w bok","Tekst",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null,"Miejsce, na ktorym chcesz postawic pionek jest niedostepne","Tekst",JOptionPane.ERROR_MESSAGE);
        }


        PrintWriter moves = new PrintWriter("moves.txt");
        moves.println(rowTo);
        moves.close();

        File file = new File("moves.txt");
        Scanner scanner = new Scanner(file);
        String sth = scanner.nextLine();
        System.out.println(sth);

        textFieldTo.clear();
        textFieldFrom.clear();
*/
    }


    public List<Integer> checkIfIsPawnToBeat(GridPane gridPane, int rowFrom, int colFrom, int rowTo, int colTo) {

        ObservableList<Node> children = gridPane.getChildren();
        List<Integer> coordinates = new ArrayList<>();
        int checkingRow = 0;
        int checkingCol = 0;

        for (int i = 1; i < Math.abs(rowTo - rowFrom); i++) {
            if (rowTo > rowFrom && colTo > colFrom) {
                checkingRow = rowFrom + i;
                checkingCol = colFrom + i;
            } else if (rowTo < rowFrom && colTo > colFrom) {
                checkingRow = rowFrom - i;
                checkingCol = colFrom + i;
            } else if (rowTo > rowFrom && colTo < colFrom) {
                checkingRow = rowFrom + i;
                checkingCol = colFrom - i;
            } else if (rowTo < rowFrom && colTo < colFrom) {
                checkingRow = rowFrom - i;
                checkingCol = colFrom - i;
            }
            for (Node node : children) {
                if (gridPane.getRowIndex(node) == checkingRow && gridPane.getColumnIndex(node) == checkingCol) {
                    coordinates.add(0,checkingCol);
                    coordinates.add(1,checkingRow);
                    break;
                }
            }
            if (coordinates.size() == 2) {
                break;
            }
        }
        return coordinates;
    }


    public void beat(GridPane gridPane,int rowTo, int colTo, Pawn movingPawn, Pawn beatenPawn){

        ObservableList <Node> children = gridPane.getChildren();
        int beatenNodeRow = 0;
        int beatenNodeCol = 0;
        int rowFrom = 0;
        int colFrom = 0;
        Node newPlace = null;


        for (Node node : children) {
            if (movingPawn.getNode() == node) {
                rowFrom = gridPane.getRowIndex(node);
                colFrom = gridPane.getColumnIndex(node);
                break;
            }
        }
        for (Node node : children) {
            if (beatenPawn.getNode() == node) {
                beatenNodeRow = gridPane.getRowIndex(node);
                beatenNodeCol = gridPane.getColumnIndex(node);
            }
        }

        if (rowTo > rowFrom && colTo > colFrom) {
            rowTo = beatenNodeRow + 1;
            colTo = beatenNodeCol + 1;
        } else if (rowTo < rowFrom && colTo > colFrom) {
            rowTo = beatenNodeRow - 1;
            colTo = beatenNodeCol + 1;
        } else if (rowTo > rowFrom && colTo < colFrom) {
            rowTo = beatenNodeRow + 1;
            colTo = beatenNodeCol - 1;
        } else if (rowTo < rowFrom && colTo < colFrom) {
            rowTo = beatenNodeRow - 1;
            colTo = beatenNodeCol - 1;
        }

        for (Node node : children) {
            if (gridPane.getRowIndex(node) == rowTo && gridPane.getColumnIndex(node) == colTo) {
                newPlace = node;
                break;
            }
        }
        if (newPlace == null) {
            if (movingPawn.getColour() != beatenPawn.getColour()) {
                if (!movingPawn.isQueen()) {
                    if (colTo == colFrom + 2 || colTo == colFrom - 2) {
                        if (rowTo == rowFrom + 2 || rowTo == rowFrom - 2) {
                            gridPane.getChildren().remove(movingPawn.getNode());
                            gridPane.getChildren().remove(beatenPawn.getNode());
                            if (movingPawn.getColour().equals("red") && rowTo == 1) {
                                movingPawn.setQueen(true);
                                movingPawn.setNode();
                            } else if (movingPawn.getColour().equals("blue") && rowTo == 8) {
                                movingPawn.setQueen(true);
                                movingPawn.setNode();
                            }
                            gridPane.add(movingPawn.getNode(), colTo, rowTo);
                        } else {
                            JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (Math.abs(rowTo-rowFrom) == (Math.abs(colFrom-colTo))) {
                        gridPane.getChildren().remove(movingPawn.getNode());
                        gridPane.getChildren().remove(beatenPawn.getNode());
                        gridPane.add(movingPawn.getNode(), colTo, rowTo);
                    } else {
                        JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
        }
        textFieldTo.clear();
        textFieldFrom.clear();

    }


    public void move(GridPane gridPane, int rowTo, int colTo, Pawn movingPawn) {

        ObservableList <Node> children = gridPane.getChildren();
        int rowFrom = 0;
        int colFrom = 0;

        for (Node node : children) {
            if (movingPawn.getNode() == node) {
                rowFrom = gridPane.getRowIndex(node);
                colFrom = gridPane.getColumnIndex(node);
                break;
            }
        }

        if (!movingPawn.isQueen()) {
            if (colTo == colFrom + 1 || colTo == colFrom - 1) {
                if (movingPawn.getColour().equals("red")){
                    if (rowTo == rowFrom - 1){
                        gridPane.getChildren().remove(movingPawn.getNode());
                        if (rowTo == 1) {
                            movingPawn.setQueen(true);
                            movingPawn.setNode();
                        }
                        gridPane.add(movingPawn.getNode(),colTo,rowTo);
                    } else {
                        JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
                    }
                } else if (movingPawn.getColour().equals("blue")) {
                    if (rowTo == rowFrom + 1) {
                        gridPane.getChildren().remove(movingPawn.getNode());
                        if (rowTo ==8) {
                            movingPawn.setQueen(true);
                            movingPawn.setNode();
                        }
                        gridPane.add(movingPawn.getNode(),colTo,rowTo);
                    } else {
                        JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            if (Math.abs(rowTo-rowFrom) == (Math.abs(colFrom-colTo))) {
                gridPane.getChildren().remove(movingPawn.getNode());
                gridPane.add(movingPawn.getNode(),colTo,rowTo);
            } else {
                JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
            }

        }
        textFieldTo.clear();
        textFieldFrom.clear();

    }


    public Pawn convertCoordinatesToPawn(GridPane gridPane, int checkingRow, int checkingCol) {
        ObservableList<Node> children = gridPane.getChildren();
        Node newNode = null;
        Pawn searchingPawn = null;
        List<Pawn> allPawns = Stream.concat(redsList.stream(),bluesList.stream()).collect(Collectors.toList());

            for (Node node : children) {
                if (gridPane.getRowIndex(node) == checkingRow && gridPane.getColumnIndex(node) == checkingCol) {
                    newNode = node;
                    break;
                }
            }
            for (Pawn pawn : allPawns) {
                if (pawn.getNode()== newNode) {
                    searchingPawn = pawn;
                    break;
            }
        }
        return searchingPawn;
    }


    public boolean isEmpty (GridPane gridPane, int row, int col) {
        ObservableList<Node> children = gridPane.getChildren();
        Node newNode = null;
        boolean empty = false;
        for (Node node : children) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == col) {
                newNode = node;
                break;
            }
        }
        if (newNode == null) {
            empty = true;
        }
        return empty;
    }


    public void moveBack(GridPane gridPane, List<Integer> moveCoordinates, List<Pawn> movedPawns) {
        int rowFrom = moveCoordinates.get(0);
        int colFrom = moveCoordinates.get(1);

        Pawn movingPawn = movedPawns.get(movedPawns.size()-1);

        gridPane.getChildren().remove(movingPawn.getNode());
        gridPane.add(movingPawn.getNode(),colFrom,rowFrom);
    }


    public  void countPoints(GridPane gridPane) {
        List<Pawn> allPawns = Stream.concat(redsList.stream(),bluesList.stream()).collect(Collectors.toList());
        ObservableList<Node> children = gridPane.getChildren();
        int redsOnBoard = 0;
        int bluesOnBoard = 0;

        for (Node node : children) {
            for (Pawn pawn : allPawns) {
                if (node == pawn.getNode()) {
                    if (pawn.getColour().equals("red")) {
                        redsOnBoard = redsOnBoard + 1;
                    } else {
                        bluesOnBoard = bluesOnBoard + 1;
                    }
                }
            }
        }
        redPoints.setText(String.valueOf(redsOnBoard));
        bluePoints.setText(String.valueOf(bluesOnBoard));
        if(redsOnBoard == 0) {
            JOptionPane.showMessageDialog(null,"Blue wins!","Tekst",JOptionPane.ERROR_MESSAGE);
        } else if (bluesOnBoard == 0) {
            JOptionPane.showMessageDialog(null,"Red wins!","Tekst",JOptionPane.ERROR_MESSAGE);
        }

    }


    public List<Integer> decode() {
        String coordinatesFrom = textFieldFrom.getText();
        String coordinatesTo = textFieldTo.getText();
        List<String> coordinatesBeforeDecoding = new ArrayList<>();

        if (coordinatesFrom.length() >=2 && coordinatesTo.length()>=2) {
            coordinatesBeforeDecoding.add(String.valueOf(coordinatesFrom.charAt(1)));
            coordinatesBeforeDecoding.add(String.valueOf(coordinatesFrom.charAt(0)));
            coordinatesBeforeDecoding.add(String.valueOf(coordinatesTo.charAt(1)));
            coordinatesBeforeDecoding.add(String.valueOf(coordinatesTo.charAt(0)));
        } else {
            JOptionPane.showMessageDialog(null,"Wprowadziles niepoprawne dane","Tekst",JOptionPane.ERROR_MESSAGE);
        }

        int result = 0;

        List<Integer> decoded = new ArrayList<>();
        Map<String, Integer> decoder = new HashMap<>();
        decoder.put("A", 2);
        decoder.put("B", 3);
        decoder.put("C", 4);
        decoder.put("D", 5);
        decoder.put("E", 6);
        decoder.put("F", 7);
        decoder.put("G", 8);
        decoder.put("H", 9);
        decoder.put("1", 1);
        decoder.put("2", 2);
        decoder.put("3", 3);
        decoder.put("4", 4);
        decoder.put("5", 5);
        decoder.put("6", 6);
        decoder.put("7", 7);
        decoder.put("8", 8);

        for (String item : coordinatesBeforeDecoding) {

            if (decoder.containsKey(item.toUpperCase())) {
                result = decoder.get(item.toUpperCase());
                decoded.add(result);
            } else {
                JOptionPane.showMessageDialog(null, "Wprowadz lokalizacje na szachownicy", "Tekst", JOptionPane.ERROR_MESSAGE);
            }
        }
        return decoded;
    }
}
