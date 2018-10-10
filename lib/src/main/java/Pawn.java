import java.util.List;
import java.util.Map;

public class Pawn extends Piece {
    public Pawn() {
        setName("pawn");
        setOnBoard(false);
    }

    public List<Integer> getOccupiedCells(int x, int y, Board board) {
//        List<Cell> cells = new ArrayList<>();
//        attackedCells.clear();
        arrClosedCells.clear();
//        cells.add(new Cell(x, y, CellState.BUSY));
//        cells.add(new Cell(x - 1, y + 1, CellState.ATTACKED));
        putAttackedCell(x - 1, y + 1, board);
//        cells.add(new Cell(x + 1, y + 1, CellState.ATTACKED));
        putAttackedCell(x + 1, y + 1, board);
        return arrClosedCells;
    }
}
