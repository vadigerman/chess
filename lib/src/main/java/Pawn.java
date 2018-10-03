import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn() {
        setName("pawn");
        setOnBoard(false);
    }

    public List<Cell> getOccupiedCells(int x, int y, Board board) {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(x, y, CellState.BUSY));
        cells.add(new Cell(x - 1, y + 1, CellState.ATTACKED));
        cells.add(new Cell(x + 1, y + 1, CellState.ATTACKED));
        return cells;
    }
}
