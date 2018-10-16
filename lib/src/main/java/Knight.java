import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight() {
        setName(ConfigBoard.KNIGHT);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
                        addOccupiedCells(cell, i, j, board);
                    }
                }
            }
        }
    }

    @Override
    protected List<Cell> calculateOccupiedCells2(int x, int y, Board board) {
        List<Cell> result = new ArrayList<>();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
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
