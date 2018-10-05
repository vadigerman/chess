import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {
    public Bishop() {
        setName("bishop");
        setOnBoard(false);
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
                    if (i != x || j != y) {
                        addWRCell(i, j, board, mapWRCells);
                    }
                }
            }
        }
        return mapWRCells;
    }

    public boolean checkOccupiedCell(int x, int y, Board board) {
        int n = board.getSize();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
                    if (i != x || j != y) {
                        if (!checkWRCell(i, j, board, mapWRCells)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
