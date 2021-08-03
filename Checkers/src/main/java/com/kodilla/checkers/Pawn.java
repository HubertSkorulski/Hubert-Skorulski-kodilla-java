package com.kodilla.checkers;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Pawn {
    private final Image bluePawn = new Image("file:src/main/resources/bluepawn.png", 75, 75, false, true);
    private final Image redPawn = new Image("file:src/main/resources/redpawn.png", 75, 75, true, true);
    private final Image redQueen = new Image("file:src/main/resources/redQueen.png", 75, 75, false, true);
    private final Image blueQueen = new Image("file:src/main/resources/blueQueen.png", 75, 75, false, true);

    private final String colour;
    private boolean queen;
    private Node node;

    public Pawn(String colour, boolean queen) {
        this.colour = colour;
        this.queen = queen;
    }

    public String getColour() {
        return colour;
    }

    public boolean isQueen() {
        return queen;
    }

    public void setQueen(boolean newStatus) {
        if (newStatus) {
            queen = true;
        }
    }

    public void setNode() {
        if (colour.equals("red")) {
            if (queen) {
                node = new ImageView(redQueen);
            } else {
                node = new ImageView(redPawn);
            }
        } else if (colour.equals("blue")) {
            if (queen) {
                node = new ImageView(blueQueen);
            } else {
                node = new ImageView(bluePawn);
            }
        }
    }

    public Node getNode() {
        return node;
    }

}

