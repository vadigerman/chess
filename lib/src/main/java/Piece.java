import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Piece {
    String name;
    List<Cell> boardOccupiedCells;
    List<Cell> closedCells;
    boolean onBoard;

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

    public List<Cell> getBoardOccupiedCells() {
        return boardOccupiedCells;
    }

    public void setBoardOccupiedCells(List<Cell> boardOccupiedCells) {
        this.boardOccupiedCells = boardOccupiedCells;
    }

    public List<Cell> getClosedCells() {
        return closedCells;
    }

    public void setClosedCells(List<Cell> closedCells) {
        this.closedCells = closedCells;
    }

    public void addClosedCell(Cell cell) {
        List<Cell> cellList;
        if (getClosedCells() == null) {
            cellList = new ArrayList<>();
        } else {
            cellList = getClosedCells();
        }
        cellList.add(cell);
        setClosedCells(cellList);
    }

    public void addWRCell(int i, int j, Board board, Map<Integer, WeakReference<Cell>> mapWRCells) {
        int key = i * 100 + j;
        WeakReference<Cell> wrCell = board.getFreeCells().get(key);
        if (wrCell != null) {
            mapWRCells.put(key, wrCell);
        }
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells(int x, int y, Board board) {
        Map<Integer, WeakReference<Cell>> cells = new HashMap<>();
       // getOccupiedCellsInt(cells);
        return cells;
    }
    //protected abstract void getOccupiedCellsInt(List<Cell> cells);
}
