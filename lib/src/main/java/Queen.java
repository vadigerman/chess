import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen() {
        setName(ConfigBoard.QUEEN);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == x) || (j == y) || (i - j == x - y) || (i + j == x + y)) {
                    if (!(i == x && j == y)) {
                        addOccupiedCells(cell, i, j, board);
                    }
                }
            }
        }
    }

    @Override
    protected List<Cell> calculateOccupiedCells2(int x, int y, Board board) {
        System.out.println("Executed calculateOccupiedCells2");
       // clearOccupiedCells();
        List<Cell> result = new ArrayList<>();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == x) || (j == y) || (i - j == x - y) || (i + j == x + y)) {
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
