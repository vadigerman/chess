import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Board {
    private int size;
    private List<Cell> cells;
    private Map<Cell, CellState> emptyCells = new HashMap<>();
    private Map<Cell, CellState> busyCells = new HashMap<>();
    private Map<Cell, CellState> checkedCells = new HashMap<>();
    private List<Piece> listPieces;
    private Stack<Piece> stackPieces = new Stack<>();
//    private Map<Integer, Cell> cellMap = new HashMap<>();
//    private Map<Integer, Cell> removedCells = new HashMap<>();

    public Board(ConfigBoard config) {
        this.size = config.getSizeBoard();
        this.cells = createBoard(size);
        this.listPieces = config.getListPieces();
    }

    private List<Cell> createBoard(int n) {
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Cell cell = new Cell(i, j);
                cells.add(cell);
                emptyCells.put(cell, CellState.EMPTY);
//                cellMap.put(cell.hashCode(), cell);
            }
        }
        return cells;
    }

    public Cell getFreeCell() {
        for (Map.Entry<Cell, CellState> entryCell : emptyCells.entrySet()) {
            if (entryCell.getValue() == CellState.EMPTY) {
                return entryCell.getKey();
            }
        }
        return null;
    }

    public void updateFreeCells(List<Cell> cellList) {
        for (Cell cell : cellList) {
            emptyCells.remove(cell);
        }
    }

    public Map<Cell, CellState> getEmptyCells() {
        return emptyCells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public int getSize() {
        return size;
    }

//    public Map<Integer, Cell> getCellMap() {
//        return cellMap;
//    }

//    public void updateBoard(Cell currentCell) {
//        currentCell.setState(CellState.USED);
//    }
//
//    public void returnBoardLastState() {
//        for (Map.Entry<Integer, Cell> entryCell : cellMap.entrySet()) {
//            Cell cell = entryCell.getValue();
//            if (cell.getState().equals(CellState.USED) || cell.getState().equals(CellState.CHECKED)) {
//                cell.setState(CellState.EMPTY);
//            }
//        }
//    }

    public void pushPiece() {
        stackPieces.push(listPieces.get(0));
        listPieces.remove(0);
    }

    public void popPiece() {
        listPieces.add(0, stackPieces.pop());
        listPieces.get(1);
    }

    public Piece getPiece() {
        return listPieces.get(0);
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

//    public void removeBoardCell(int key) {
//        cellMap.remove(key);
//    }
//
//    public Map<Integer, Cell> getRemovedCells() {
//        return removedCells;
//    }

//    public List<Cell> getCells() {
//        return cells;
//    }

//    public Cell getFreeCell() {
//        List<Cell> cells = getCells();
//        for (Cell cell : cells) {
//            if (cell.getState() == CellState.EMPTY) {
//                cell.setState(CellState.CHECKED);
//                return cell;
//            }
//        }
//        return null;
//    }

//    public Cell getFreeDuplicateCell() {
//        for (Map.Entry<Integer, Cell> entryCell : cellMap.entrySet()) {
//            Cell cell = entryCell.getValue();
//            if (cell.getState().equals(CellState.EMPTY)) {
//                cell.setState(CellState.CHECKED);
//                return cell;
//            }
//        }
//        return null;
//    }

//    public boolean isFreeCell() {
//        List<Cell> cells = getCells();
//        for (Cell cell : cells) {
//            if (cell.getState() == CellState.EMPTY) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public boolean isFreeDuplicateCell() {
//        for (Map.Entry<Integer, Cell> entryCell : cellMap.entrySet()) {
//            if (entryCell.getValue().getState().equals(CellState.EMPTY)) {
//                return true;
//            }
//        }
//        return false;
//    }

//    public void printBoard() {
//        List<Cell> cells = getCells();
//        for (Cell cell : cells) {
//            System.out.println(cell.getX() + "-" + cell.getY() + ": " + cell.getState());
//            System.out.println(cell.hashCode());
//        }
//    }
}


