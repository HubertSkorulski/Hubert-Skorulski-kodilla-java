package com.kodilla.checkers;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Checkers extends Application {

    private final Image checkersTable = new Image("file:src/main/resources/checkers table.png");
    private List<Integer> moveCoordinates = new ArrayList<>();
    private List<Pawn> movedPawns = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Preparing background
        BackgroundSize secondBackgroundSize = new BackgroundSize(600, 600, false, false, false, false);
        BackgroundImage secondBackgroundImage = new BackgroundImage(checkersTable, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, secondBackgroundSize);
        Background secondBackground = new Background(secondBackgroundImage);
        CheckerBoard checkerBoard = new CheckerBoard();
        GridPane grid = new GridPane();

        grid.setBackground(secondBackground);
        grid.setPadding(new Insets(74, 0, 150, 349));

        Button movePawn = new Button();
        Button moveBack = new Button();
        Button newGame = new Button();
        newGame.setText("New game");
        movePawn.setText("Move Pawn");
        moveBack.setText("Move Pawn\n    back");
        grid.add(movePawn,11,6);
        grid.add(moveBack,11,7);
        grid.add(newGame,0,1);

        movePawn.setOnAction((i) -> {
            List <Integer> coordinates = checkerBoard.decode();
            int rowFrom = 0;
            int colFrom = 0;
            int rowTo = 0;
            int colTo = 0;

            try {
                rowFrom = coordinates.get(0);
                colFrom = coordinates.get(1);
                rowTo = coordinates.get(2);
                colTo = coordinates.get(3);

            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null,"Podaj lokalizacje","Tekst",JOptionPane.ERROR_MESSAGE);
            }

            moveCoordinates.add(0,rowFrom);
            moveCoordinates.add(1,colFrom);

            if (!checkerBoard.isEmpty(grid, rowFrom,colFrom)) {
                Pawn movingPawn = checkerBoard.convertCoordinatesToPawn(grid, rowFrom, colFrom);
                if (checkerBoard.isEmpty(grid, rowTo,colTo)){
                    List<Integer> beatenCoordinates = checkerBoard.checkIfIsPawnToBeat(grid, rowFrom,colFrom, rowTo,colTo);
                    if (!beatenCoordinates.isEmpty()) {
                        int beatenRow = beatenCoordinates.get(1);
                        int beatenCol = beatenCoordinates.get(0);
                        Pawn beatenPawn = checkerBoard.convertCoordinatesToPawn(grid, beatenRow, beatenCol);
                        checkerBoard.beat(grid, rowTo, colTo, movingPawn, beatenPawn);
                    } else {
                        checkerBoard.move(grid, rowTo,colTo,movingPawn);
                        movedPawns.add(movingPawn);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null,"Niedozwolony ruch","Tekst",JOptionPane.ERROR_MESSAGE);
            }
            checkerBoard.countPoints(grid);
        });

        moveBack.setOnAction((i) -> {
            checkerBoard.moveBack(grid,moveCoordinates,movedPawns);
        });

        newGame.setOnAction((e)-> {
            checkerBoard.cleaning(grid);
            checkerBoard.startingBoard(grid);
            checkerBoard.decorateTheBoard(grid);
            checkerBoard.countPoints(grid);
            grid.add(movePawn,11,6);
            grid.add(moveBack,11,7);
            grid.add(newGame,0,1);
        });


        checkerBoard.startingBoard(grid);
        checkerBoard.decorateTheBoard(grid);

        Scene scene = new Scene(grid, 1600, 900, Color.GREEN);

        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
