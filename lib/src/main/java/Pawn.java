import java.util.List;

public class Pawn extends Piece {
    public Pawn() {
        setName(ConfigBoard.PAWN);
//        setOnBoard(false);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        addOccupiedCells(cell, x - 1, y + 1, board);
        addOccupiedCells(cell, x + 1, y + 1, board);
    }

//    public boolean isOccupiedCells(int x, int y, Board board) {
//        Cell cell = new Cell(-1, -1);
//        getOccupiedCells().clear();
//        cell.setX(x - 1);
//        cell.setY(y + 1);
//        if (!checkCell(board, cell)) {
//            return false;
//        }
//        cell.setX(x + 1);
//        cell.setY(y + 1);
//        if (!checkCell(board, cell)) {
//            return false;
//        }
//        return true;
//    }
}
