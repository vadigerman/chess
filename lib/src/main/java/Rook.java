import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook() {
        setName(ConfigBoard.ROOK);
    }

    @Override
    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        List<Cell> cellList = new ArrayList<>();
        Cell cell = new Cell(-10, -10);
        int n = board.getSize();
        for(int i = 0; i < n; i++) {
            addCellToList(cell, board, cellList, i, y);
            addCellToList(cell, board, cellList, x, i);
        }
        cell.setX(x);
        cell.setY(y);
        cellList.remove(cell);
        return cellList;
    }
}
