import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Board {
    private List<Cell> cells;
    private Map<Integer, WeakReference<Cell>> freeCells = new HashMap<>();
    private Map<Integer, WeakReference<Cell>> occupiedCells = new HashMap<>();
    private int size;
    private List<Piece> listPieces;
    private Stack<Piece> stackPieces = new Stack<>();

    public Board(ConfigBoard config) {
        this.size = config.getSizeBoard();
        this.cells = createBoard(size);
        this.listPieces = config.getListPieces();
        createWRCells();
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

    public void createWRCells() {
        for(Cell cell : getCells()) {
            freeCells.put(cell.hashCode(), new WeakReference<>(cell));
        }
    }

    public List<Cell> createBoard(int n) {
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cells.add(new Cell(i, j, CellState.EMPTY));
            }
        }
        return cells;
    }

    public int getSize() {
        return size;
    }

    public Map<Integer, WeakReference<Cell>> getFreeCells() {
        return freeCells;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Map<Integer, WeakReference<Cell>> getOccupiedCells() {
        return occupiedCells;
    }

    public Cell getFreeCell() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.EMPTY) {
                cell.setState(CellState.CHECKED);
                return cell;
            }
        }
        return null;
    }

    public WeakReference<Cell> getWRFreeCell() {
        int key = getFreeCells().entrySet().iterator().next().getKey();
        return getFreeCells().get(key);
    }

    public void replaceReferenceFreeCellByOccupied(WeakReference<Cell> wrCell) {
        int key = wrCell.get().hashCode();
        occupiedCells.put(key, wrCell);
        freeCells.remove(key);
    }

    public void updateBusyCell(Cell cell, CellState cellState, Piece piece) {
        int key = cell.hashCode();
        WeakReference<Cell> wrCell = freeCells.get(key);
        wrCell.get().setState(cellState);
        occupiedCells.put(key, wrCell);
        piece.addClosedCells(key, wrCell);
        freeCells.remove(key);
    }

    public boolean isFreeCell() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.EMPTY) {
                return true;
            }
        }
        return false;
    }

    public boolean isWRFreeCell() {
        return (getFreeCells().size() > 0);
    }

    public void printBoard() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            System.out.println(cell.getX() + "-" + cell.getY() + ": " + cell.getState());
            System.out.println(cell.hashCode());
        }
    }

    public void updateBoard(Cell currentCell) {
        int index = currentCell.getX() * size + currentCell.getY();
        getCells().get(index).setState(CellState.USED);
    }

    public void returnBoardLastState() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.USED || cell.getState() == CellState.CHECKED) {
                cell.setState(CellState.EMPTY);
            }
        }
    }

    public void pushPiece() {
        stackPieces.push(listPieces.get(0));
        listPieces.remove(0);
    }

//    public void popPiece() {
//        listPieces.add(0, stackPieces.pop());
//        listPieces.get(1).setClosedCells(null);
//    }

    public Piece getPiece() {
        return listPieces.get(0);
    }
}


