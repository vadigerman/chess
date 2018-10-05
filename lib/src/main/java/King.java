import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class King extends Piece {
    public King() {
        setName("king");
        setOnBoard(false);
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
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
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
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
