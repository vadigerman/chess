import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King() {
        setName("king");
    }

    public List<Cell> getOccupiedCells(int x, int y, int n) {
        List<Cell> cells = new ArrayList<Cell>();
        for(int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i == x && j == y) {
                    cells.add(new Cell(i, j, CellState.BUSY));
                } else {
                    cells.add(new Cell(i, j, CellState.ATTACKED));
                }
            }
        }
        return cells;
    }
}
