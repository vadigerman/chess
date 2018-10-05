import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Piece {
    String name;
    List<Cell> boardOccupiedCells;
    Map<Integer, WeakReference<Cell>> closedCells = new HashMap<>();
    boolean onBoard;

    public List<Cell> getBoardOccupiedCells() {
        return boardOccupiedCells;
    }

    public Map<Integer, WeakReference<Cell>> getClosedCells() {
        return closedCells;
    }

    public void addClosedCells(int key, WeakReference<Cell> wrCell) {
        closedCells.put(key, wrCell);
    }

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addWRCell(int i, int j, Board board, Map<Integer, WeakReference<Cell>> mapWRCells) {
        int key = i * 100 + j;
        WeakReference<Cell> wrCell = board.getFreeCells().get(key);
        if (wrCell != null) {
            mapWRCells.put(key, wrCell);
        }
    }

    public boolean checkWRCell(int i, int j, Board board, Map<Integer, WeakReference<Cell>> mapWRCells) {
        int key = i * 100 + j;
        WeakReference<Cell> wrCell = board.getOccupiedCells().get(key);
        if (wrCell != null && wrCell.get().getState() == CellState.BUSY) {
            return false;
        }
        return true;
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
        Map<Integer, WeakReference<Cell>> cells = new HashMap<>();
       // getOccupiedCellsInt(cells);
        return cells;
    }
    //protected abstract void getOccupiedCellsInt(List<Cell> cells);

    public boolean checkOccupiedCell(int x, int y, Board board) {
        return true;
    }
}
