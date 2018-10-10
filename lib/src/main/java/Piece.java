import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Piece {
    private String name;
    Map<Integer, Cell> attackedCells = new HashMap<>();
    private Map<Integer, Cell> duplicateClosedCells = new HashMap<>();
    private List<Integer> arrClosedCells = new ArrayList<>();
    private Map<Integer, Cell> duplicateAttackedCells = new HashMap<>();
    private boolean onBoard;

    public List<Integer> getArrClosedCells() {
        return arrClosedCells;
    }

    public void addArrAttackedCells(int key) {
        arrClosedCells.add(key);
    }

    public void setArrClosedCells(List<Integer> arrClosedCells) {
        this.arrClosedCells = arrClosedCells;
    }

    public Map<Integer, Cell> getDuplicateClosedCells() {
        return duplicateClosedCells;
    }

    public void addDuplicateClosedCells(Cell cell, int key) {
        duplicateClosedCells.put(key, cell);
    }

    public Map<Integer, Cell> getDuplicateAttackedCells() {
        return duplicateAttackedCells;
    }

    public void addDuplicateAttackedCells(Cell cell, int key) {
        duplicateAttackedCells.put(key, cell);
    }

    public void clearDuplicateClosedCells() {
        duplicateClosedCells.clear();
    }

    public void clearDuplicateAttackedCells() {
        duplicateAttackedCells.clear();
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

    public Map<Integer, Cell> getOccupiedCells(int x, int y, Board board) {
//        List<Cell> cells = new ArrayList<>();
       // getOccupiedCellsInt(cells);
        return attackedCells;
    }

    public void putAttackedCell(int x, int y, Board board) {
        int key = x * 100 + y;
        Cell cell = board.getDuplicateCells().get(key);
        if (cell != null) {
            attackedCells.put(key, cell);
            addArrAttackedCells(key);
        }
    }
    //protected abstract void getOccupiedCellsInt(List<Cell> cells);
}
