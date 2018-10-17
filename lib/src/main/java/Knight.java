import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight() {
        setName(ConfigBoard.KNIGHT);
    }

    @Override
    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        List<Cell> cellList = new ArrayList<>();
        Cell cell = new Cell(-10, -10);
        int n = board.getSize();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3 || (i == x && j == y)) {
                        addCellToList(cell, board, cellList, i, j);
                    }
                }
            }
        }
        return cellList;
    }
}
