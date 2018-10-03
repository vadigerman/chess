import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop() {
        setName("bishop");
        setOnBoard(false);
    }

    public List<Cell> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
                    if (i == x && j == y) {
                        cells.add(new Cell(i, j, CellState.BUSY));
                    } else {
                        cells.add(new Cell(i, j, CellState.ATTACKED));
                    }
                }
            }
        }
        return cells;
    }
}
