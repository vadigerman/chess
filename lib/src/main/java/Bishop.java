import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop() {
        setName(ConfigBoard.BISHOP);
//        setOnBoard(false);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
                    if (!(i == x && j == y)) {
                        addOccupiedCells(cell, i, j, board);
                    }
                }
            }
        }
    }

//    public boolean isOccupiedCells(int x, int y, Board board) {
//        int n = board.getSize();
//        Cell cell = new Cell(-1, -1);
//        getOccupiedCells().clear();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
//                    if (!(i == x && j == y)) {
//                        cell.setX(i);
//                        cell.setY(j);
//                        if (!checkCell(board, cell)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
