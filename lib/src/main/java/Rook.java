import java.util.List;

public class Rook extends Piece {
    public Rook() {
        setName(ConfigBoard.ROOK);
//        setOnBoard(false);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for(int i = 0; i < y; i++) {
            addOccupiedCells(cell, x, i, board);
        }
        for(int i = y + 1; i < n; i++) {
            addOccupiedCells(cell, x, i, board);
        }
        for(int i = 0; i < x; i++) {
            addOccupiedCells(cell, i, y, board);
        }
        for(int i = x + 1; i < n; i++) {
            addOccupiedCells(cell, i, y, board);
        }
    }

//    public boolean isOccupiedCells(int x, int y, Board board) {
//        int n = board.getSize();
//        Cell cell = new Cell(-1, -1);
//        getOccupiedCells().clear();
//        for(int i = 0; i < y; i++) {
//            cell.setX(x);
//            cell.setY(i);
//
//        }
//        for(int i = y + 1; i < n; i++) {
//            cell.setX(x);
//            cell.setY(i);
//
//        }
//        for(int i = 0; i < x; i++) {
//            cell.setX(i);
//            cell.setY(y);
//
//        }
//        for(int i = x + 1; i < n; i++) {
//            cell.setX(i);
//            cell.setY(y);
//
//        }
//        return true;
//    }
}
