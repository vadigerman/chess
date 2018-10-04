import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {
    public Rook() {
        setName("rook");
        setOnBoard(false);
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
//        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < y; i++) {
            addWRCell(x, i, board, mapWRCells);
//            cells.add(new Cell(x, i, CellState.ATTACKED));
        }
        for(int i = y + 1; i < n; i++) {
            addWRCell(x, i, board, mapWRCells);
//            cells.add(new Cell(x, i, CellState.ATTACKED));
        }
        for(int i = 0; i < x; i++) {
            addWRCell(i, y, board, mapWRCells);
//            cells.add(new Cell(i, y, CellState.ATTACKED));
        }
        for(int i = x + 1; i < n; i++) {
            addWRCell(i, y, board, mapWRCells);
//            cells.add(new Cell(i, y, CellState.ATTACKED));
        }
//        cells.add(new Cell(x, y, CellState.BUSY));
        return mapWRCells;
    }
}
