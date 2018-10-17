import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King() {
        setName(ConfigBoard.KING);
    }

    @Override
    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        List<Cell> cellList = new ArrayList<>();
        int n = board.getSize();
        Cell cell = new Cell(-10, -10);
        for(int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    addCellToList(cell, board, cellList, i, j);
                }
            }
        }
        return cellList;
    }
}
