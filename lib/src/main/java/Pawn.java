import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn() {
        setName(ConfigBoard.PAWN);
    }

    @Override
    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        List<Cell> cellList = new ArrayList<>();
        Cell cell = new Cell(-10, -10);
        addCellToList(cell, board, cellList, x - 1, y + 1);
        addCellToList(cell, board, cellList, x + 1, y + 1);
        addCellToList(cell, board, cellList, x, y);
        return cellList;
    }
}
