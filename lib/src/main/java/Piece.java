import java.util.ArrayList;
import java.util.List;

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
            cellList = new ArrayList<Cell>();
        } else {
            cellList = getClosedCells();
        }
        cellList.add(cell);
        setClosedCells(cellList);
    }

    public List<Cell> getOccupiedCells(int x, int y, int n) {
        List<Cell> cells = new ArrayList<Cell>();
        return cells;
    }
}
