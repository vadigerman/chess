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
        for(int i = 0; i < y; i++) {
            addWRCell(x, i, board, mapWRCells);
        }
        for(int i = y + 1; i < n; i++) {
            addWRCell(x, i, board, mapWRCells);
        }
        for(int i = 0; i < x; i++) {
            addWRCell(i, y, board, mapWRCells);
        }
        for(int i = x + 1; i < n; i++) {
            addWRCell(i, y, board, mapWRCells);
        }
        return mapWRCells;
    }

    public boolean checkOccupiedCell(int x, int y, Board board) {
        int n = board.getSize();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
        for(int i = 0; i < y; i++) {
            if (!checkWRCell(x, i, board, mapWRCells)) {
                return false;
            }
        }
        for(int i = y + 1; i < n; i++) {
            if (!checkWRCell(x, i, board, mapWRCells)) {
                return false;
            }
        }
        for(int i = 0; i < x; i++) {
            if (!checkWRCell(i, y, board, mapWRCells)) {
                return false;
            }
        }
        for(int i = x + 1; i < n; i++) {
            if (!checkWRCell(i, y, board, mapWRCells)) {
                return false;
            }
        }
        return true;
    }
}
