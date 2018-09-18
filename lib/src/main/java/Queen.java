import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {
    public Queen() {
        setName("queen");
    }

    public List<Cell> getOccupiedCells(int x, int y, int n) {
        List<Cell> cells = new ArrayList<Cell>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == x) || (j == y) || (i - j == x - y) || (i + j == x + y)) {
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
