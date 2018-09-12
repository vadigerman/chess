package main.java;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int size;

    public Board(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Integer> getSquares() {
        List<Integer> squares = new ArrayList<Integer>();
        for (int i = 0; i < size*size; i++) {
            squares.add(i + 1);
        }
        return squares;
    }
}


