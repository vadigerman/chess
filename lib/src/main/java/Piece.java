import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class Piece {
    String name;
    Map<Integer, WeakReference<Cell>> boardOccupiedCells = new HashMap<>();
    Map<Integer, WeakReference<Cell>> closedCells = new HashMap<>();
    boolean onBoard;

    public Map<Integer, WeakReference<Cell>> getBoardOccupiedCells() {
        return boardOccupiedCells;
    }

    public void setBoardOccupiedCells(Map<Integer, WeakReference<Cell>> boardOccupiedCells) {
        this.boardOccupiedCells = boardOccupiedCells;
    }

    public void addBoardOccupiedCells(int key, WeakReference<Cell> wrCell) {
        boardOccupiedCells.put(key, wrCell);
    }

    public Map<Integer, WeakReference<Cell>> getClosedCells() {
        return closedCells;
    }

    public void setClosedCells(Map<Integer, WeakReference<Cell>> closedCells) {
        this.closedCells = closedCells;
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

    public boolean checkCloseCell(Cell cell) {
        return (getClosedCells().get(cell.getX() * 100 + cell.getY()) == null);
    }

    public boolean checkOccupiedCell(int x, int y, Board board) {
        return true;
    }
}
