import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King() {
        setName(ConfigBoard.KING);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        int n = board.getSize();
        Cell cell = new Cell(-1, -1);
        for(int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if (!(i == x && j == y)) {
                        addOccupiedCells(cell, i, j, board);
                    }
                }
            }
        }
    }

    @Override
    protected List<Cell> calculateOccupiedCells2(int x, int y, Board board) {
        List<Cell> result = new ArrayList<>();
        int n = board.getSize();
        Cell cell = new Cell(-1, -1);
        for(int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if (!(i == x && j == y)) {
                        cell.setX(i);
                        cell.setY(j);
                        result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
                    }
                }
            }
        }
        return result;
    }
}
