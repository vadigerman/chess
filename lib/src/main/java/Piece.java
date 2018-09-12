package main.java;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    String name;
    int activeSquare;

    public Piece(int activeSquare) {
        this.activeSquare = activeSquare;
    }

    public List<Integer> getPossibleMoves(int sizeBoard) {
        List<Integer> possibleMoves = new ArrayList<Integer>();
        return possibleMoves;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getActiveSquare() {
        return activeSquare;
    }

    public void setActiveSquare(int activeSquare) {
        this.activeSquare = activeSquare;
    }
}
