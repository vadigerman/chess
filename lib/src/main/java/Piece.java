import java.util.ArrayList;
import java.util.List;

public class Piece {
    private String name;
    private List<Cell> occupiedCells = new ArrayList<>();
//    private Map<Integer, Cell> duplicateClosedCells = new HashMap<>();
//    List<Integer> arrOccAttCells = new ArrayList<>();
//    private Map<Integer, Cell> duplicateAttackedCells = new HashMap<>();
//    private List<Integer> arrClosedCells = new ArrayList<>();
//    private List<Integer> arrAttackedCells = new ArrayList<>();
    private boolean onBoard;

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public List<Cell> getOccupiedCells() {
        return occupiedCells;
    }

    public void setOccupiedCells(List<Cell> occupiedCells) {
        this.occupiedCells = occupiedCells;
    }

    public boolean checkCell(Board board, Cell cell) {
        if (cell.equals(board.getCells().get(board.getCells().indexOf(cell)))) {
            if (board.getEmptyCells().get(cell) == CellState.EMPTY) {
                getOccupiedCells().add(board.getCells().get(board.getCells().indexOf(cell)));
            } else if (board.getEmptyCells().get(cell) == CellState.BUSY) {
                return false;
            }
        }
        return true;
    }

//    public void addOccArrCells(int key) {
//        arrOccAttCells.add(key);
//    }
//
//    public Map<Integer, Cell> getDuplicateClosedCells() {
//        return duplicateClosedCells;
//    }
//
//    public void addDuplicateClosedCells(Cell cell, int key) {
//        duplicateClosedCells.put(key, cell);
//    }
//
//    public Map<Integer, Cell> getDuplicateAttackedCells() {
//        return duplicateAttackedCells;
//    }
//
//    public void addDuplicateAttackedCells(Cell cell, int key) {
//        duplicateAttackedCells.put(key, cell);
//    }
//
//    public void clearDuplicateClosedCells() {
//        duplicateClosedCells.clear();
//    }
//
//    public void clearDuplicateAttackedCells() {
//        duplicateAttackedCells.clear();
//    }

//    public boolean isOnBoard() {
//        return onBoard;
//    }
//
//    public void setOnBoard(boolean onBoard) {
//        this.onBoard = onBoard;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
//        List<Cell> cells = new ArrayList<>();
       // getOccupiedCellsInt(cells);
        return true;
    }
    //protected abstract void getOccupiedCellsInt(List<Cell> cells);

//    public void putAttackedCell(int x, int y, Board board) {
//        int key = x * 100 + y;
//        Cell cell = board.getCellMap().get(key);
//        if (cell != null) {
////            attackedCells.put(key, cell);
//            addOccArrCells(key);
//        }
//    }

//    public List<Integer> getArrClosedCells() {
//        return arrClosedCells;
//    }
//
//    public void clearArrClosedCells() {
//        arrClosedCells.clear();
//    }
//
//    public void clearArrAttackedCells() {
//        arrAttackedCells.clear();
//    }
//
//    public void setArrClosedCells(List<Integer> arrClosedCells) {
//        this.arrClosedCells = arrClosedCells;
//    }
//
//    public List<Integer> getArrAttackedCells() {
//        return arrAttackedCells;
//    }
//
//    public void setArrAttackedCells(List<Integer> arrAttackedCells) {
//        this.arrAttackedCells = arrAttackedCells;
//    }
//
//    public List<Integer> getArrOccAttCells() {
//        return arrOccAttCells;
//    }

//    public void addArrClosedCells(int key) {
//        arrClosedCells.add(0, key);
//    }
//
//    public void addArrAttackedCells(int key) {
//        arrAttackedCells.add(key);
//    }
}
