import java.util.List;
import java.util.Map;

public class Rook extends Piece {
    public Rook() {
        setName("rook");
        setOnBoard(false);
    }

    public List<Integer> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
//        List<Cell> cells = new ArrayList<>();
//        attackedCells.clear();
        arrClosedCells.clear();
        for(int i = 0; i < y; i++) {
//            cells.add(new Cell(x, i, CellState.ATTACKED));
            putAttackedCell(x, i, board);
        }
        for(int i = y + 1; i < n; i++) {
//            cells.add(new Cell(x, i, CellState.ATTACKED));
            putAttackedCell(x, i, board);
        }
        for(int i = 0; i < x; i++) {
//            cells.add(new Cell(i, y, CellState.ATTACKED));
            putAttackedCell(i, y, board);
        }
        for(int i = x + 1; i < n; i++) {
//            cells.add(new Cell(i, y, CellState.ATTACKED));
            putAttackedCell(i, y, board);
        }
//        cells.add(new Cell(x, y, CellState.BUSY));
        return arrClosedCells;
    }
}
