import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook() {
        setName("rook");
        setOnBoard(false);
    }

    public List<Cell> getOccupiedCells(int x, int y, int n) {
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < y; i++) {
            cells.add(new Cell(x, i, CellState.ATTACKED));
        }
        for(int i = y + 1; i < n; i++) {
            cells.add(new Cell(x, i, CellState.ATTACKED));
        }
        for(int i = 0; i < x; i++) {
            cells.add(new Cell(i, y, CellState.ATTACKED));
        }
        for(int i = x + 1; i < n; i++) {
            cells.add(new Cell(i, y, CellState.ATTACKED));
        }
        cells.add(new Cell(x, y, CellState.BUSY));
        return cells;
    }
}
