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

    public List<Cell> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        List<Cell> cells = new ArrayList<>();
//        int key = 0;
//        List<WeakReference<Cell>> cellList = new ArrayList<>();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
//                        key = i * 100 + j;
//                        HashMap<Integer, WeakReference<Cell>> hashMapCells = board.getFreeCells();
//                        Set<Map.Entry<Integer, WeakReference<Cell>>> setCells = board.getFreeCells().entrySet();
//                        for(Map.Entry<Integer, WeakReference<Cell>> entryCell : setCells) {
//                            if (entryCell.hashCode() == key) {
//
//                            }
//                        }
                        cells.add(new Cell(i, j, CellState.ATTACKED));
                    } else if (i == x && j == y) {
                        cells.add(new Cell(i, j, CellState.BUSY));
                    }
                }
            }
        }
        return cells;
    }
}
