import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Knight extends Piece {
    public Knight() {
        setName("knight");
        setOnBoard(false);
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
//        List<Cell> cells = new ArrayList<>();
        int n = board.getSize();
        Map<Integer, WeakReference<Cell>> mapWRCells = new HashMap<>();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
                        addWRCell(i, j, board, mapWRCells);
//                        cells.add(new Cell(i, j, CellState.ATTACKED));
//                    } else if (i == x && j == y) {
//                        cells.add(new Cell(i, j, CellState.BUSY));
                    }
                }
            }
        }
        return mapWRCells;
    }
}
