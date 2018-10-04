import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pawn extends Piece {
    public Pawn() {
        setName("pawn");
        setOnBoard(false);
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
//        List<Cell> cells = new ArrayList<>();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
        int key;
        WeakReference<Cell> wrCell;
        for (int i = - 1; i <= 1; i = i + 2) {
            key = (x + i) * 100 + y + 1;
            wrCell = board.getFreeCells().get(key);
            if (wrCell != null) {
                mapWRCells.put(key, wrCell);
            }
        }
        return mapWRCells;
    }
}
