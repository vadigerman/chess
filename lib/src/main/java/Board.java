import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Board {
    private int size;
    private List<Cell> cells = new ArrayList<>();
    private List<Cell> busyCells = new ArrayList<>();
    private List<Piece> listPieces;
//    private Map<Cell, CellState> emptyCells = new HashMap<>();
//    private Map<Cell, CellState> busyCells = new HashMap<>();
//    private Stack<Piece> stackPieces = new Stack<>();

    public Board(Board that) {
        this.size = that.size;
        this.cells = that.cells;
        this.busyCells = that.busyCells;
        this.listPieces = that.listPieces;
    }

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
//                emptyCells.put(cell, CellState.EMPTY);
            }
        }
        return cells;
    }

    public Cell getFreeCell() {
//        for (Map.Entry<Cell, CellState> entryCell : emptyCells.entrySet()) {
//            if (entryCell.getValue() == CellState.EMPTY) {
//                return entryCell.getKey();
//            }
//        }
        if (getCells().size() > 0) {
            return getCells().get(0);
        } else {
            return null;
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Cell> getBusyCells() {
        return busyCells;
    }

    public int getSize() {
        return size;
    }

    public Piece getPiece(int i) {
        return listPieces.get(i);
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

//    public Map<Cell, CellState> getBusyCells() {
//        return busyCells;
//    }

//    public void updateClosedCells(Piece piece) {
//        for (Cell cell : piece.getClosedCells()) {
//            getEmptyCells().remove(cell);
//            getEmptyCells().put(cell, CellState.CHECKED);
//        }
//    }

//    public void updateFreeCells(List<Cell> cellList, Piece piece) {
////        piece.getUsedCells().clear();
//        for (Cell cell : cellList) {
//            emptyCells.remove(cell);
//            piece.getUsedCells().put(cell, CellState.ATTACKED);
//        }
//    }

//    public void removeClosedCells(Piece piece) {
//        for (Cell cell : piece.getClosedCells()) {
//            getEmptyCells().put(cell, CellState.EMPTY);
//        }
//        for (Map.Entry<Cell, CellState> entryCell : piece.getUsedCells().entrySet()) {
//            getEmptyCells().put(entryCell.getKey(), CellState.EMPTY);
//        }
//    }

//    public void returnLastState(Piece piece) {
//        for (Map.Entry<Cell, CellState> entryCell : piece.getUsedCells().entrySet()) {
//            getEmptyCells().remove(entryCell.getKey());
//            getEmptyCells().put(entryCell.getKey(), CellState.EMPTY);
//        }
//        for (Cell cell : piece.getClosedCells()) {
//            getEmptyCells().remove(cell);
//            getEmptyCells().put(cell, CellState.EMPTY);
//        }
//        piece.getUsedCells().clear();
//    }

//    public Map<Cell, CellState> getEmptyCells() {
//        return emptyCells;
//    }

    public void pushPiece() {
//        stackPieces.push(listPieces.get(0));
        listPieces.remove(0);
    }

    public void popPiece() {
//        listPieces.add(0, stackPieces.pop());
        listPieces.get(1).getClosedCells().clear();
    }
}


