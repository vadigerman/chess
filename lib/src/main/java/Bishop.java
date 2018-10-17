import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop() {
        setName(ConfigBoard.BISHOP);
    }

    @Override
    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        List<Cell> cellList = new ArrayList<>();
        Cell cell = new Cell(-10, -10);
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
                    addCellToList(cell, board, cellList, i, j);
                }
            }
        }
        return cellList;
    }
}
