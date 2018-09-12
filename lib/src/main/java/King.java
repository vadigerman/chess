package main.java;

import java.util.ArrayList;
import java.util.List;

public class King extends main.java.Piece {
    public King(int activeSquare) {
        super(activeSquare);
    }

    public List<Integer> getPossibleMoves(int sizeBoard) {
        List<Integer> possibleMoves = new ArrayList<Integer>();
        possibleMoves.add(activeSquare - 1);
        possibleMoves.add(activeSquare + 1);
        for (int i = -1; i < 2; i++) {
            possibleMoves.add(activeSquare - sizeBoard + i);
            possibleMoves.add(activeSquare + sizeBoard + i);
        }
        return possibleMoves;
    }
}
