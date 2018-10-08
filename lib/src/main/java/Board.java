import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Board {
    private List<Cell> cells;
    private Map<Integer, WeakReference<Cell>> freeCells = new HashMap<>();
    private Map<Integer, WeakReference<Cell>> occupiedWrCells = new HashMap<>();
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
        return occupiedWrCells;
    }

    public Cell getWRFreeCell(Piece piece) {
        getFreeCells().entrySet();
        for (Map.Entry<Integer, WeakReference<Cell>> entry : getFreeCells().entrySet()) {
            Cell cell = entry.getValue().get();
            if (piece.getClosedCells().get(cell.hashCode()) == null) {
                return cell;
            }
        }
        return null;
    }

    public void replaceReferenceFreeCellByOccupied(WeakReference<Cell> wrCell, Piece piece) {
        int key = wrCell.get().hashCode();
        occupiedWrCells.put(key, wrCell);
        piece.addBoardOccupiedCells(key, wrCell);
        freeCells.remove(key);
    }

    public void pushPiece() {
        stackPieces.push(listPieces.get(0));
        listPieces.remove(0);
    }

    public void popPiece() {
        listPieces.get(0).getClosedCells().clear();
        if (!stackPieces.isEmpty()) {
            listPieces.add(0, stackPieces.pop());
        }
    }

    public Piece getPiece() {
        return listPieces.get(0);
    }

    public void updateBusyCell(Cell cell, CellState cellState, Piece piece) {
        Integer key = cell.hashCode();
        WeakReference<Cell> wrCell = getFreeCells().get(key);
        wrCell.get().setState(cellState);
        occupiedWrCells.put(key, wrCell);
        piece.addClosedCells(key, wrCell);
        freeCells.remove(key);
    }

    public void removeWrCells(WeakReference<Cell> wrCell) {
        Integer key = wrCell.get().hashCode();
        freeCells.put(key, wrCell);
        occupiedWrCells.remove(key);
    }

    public void removePiece(Piece piece) {
        Map<Integer, WeakReference<Cell>> occupiedCells = piece.getBoardOccupiedCells();
        for (Map.Entry<Integer, WeakReference<Cell>> entry : occupiedCells.entrySet()) {
            WeakReference<Cell> wrCell = entry.getValue();
            removeWrCells(wrCell);
        }
        piece.getBoardOccupiedCells().clear();

        Map<Integer, WeakReference<Cell>> closedCells = piece.getClosedCells();
        for (Map.Entry<Integer, WeakReference<Cell>> entry : closedCells.entrySet()) {
            WeakReference<Cell> wrCell = entry.getValue();
            if (wrCell.get().getState() == CellState.BUSY) {
                wrCell.get().setState(CellState.ATTACKED);
            }
            removeWrCells(wrCell);
        }
    }

    public void returnBoardLastState(Piece piece) {
        Map<Integer, WeakReference<Cell>> closedCells = piece.getClosedCells();
        for (Map.Entry<Integer, WeakReference<Cell>> entry : closedCells.entrySet()) {
            WeakReference<Cell> wrCell = entry.getValue();
            removeWrCells(wrCell);
        }
        piece.getClosedCells().clear();
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
}


