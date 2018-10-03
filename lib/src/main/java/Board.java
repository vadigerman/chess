import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Board {
    private List<Cell> cells;
    private HashMap<Integer, WeakReference<Cell>> freeCells = new HashMap<>();
    private HashMap<Integer, WeakReference<Cell>> occupiedCells = new HashMap<>();
    private int size;
    private List<Piece> listPieces;
    private Stack<Piece> stackPieces = new Stack<>();

    public Board(ConfigBoard config) {
        this.size = config.getSizeBoard();
        this.cells = createBoard(size);
        this.listPieces = config.getListPieces();
        createWRCells();
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

    public HashMap<Integer, WeakReference<Cell>> getFreeCells() {
        return freeCells;
    }

    public List<Cell> getCells() {
        return cells;
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
        return getFreeCells().get(0);
    }

    public void updateWRCells() {
        int key = getWRFreeCell().get().hashCode();
        occupiedCells.put(key, getWRFreeCell());
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

    public void popPiece() {
        listPieces.add(0, stackPieces.pop());
        listPieces.get(1).setClosedCells(null);
    }

    public Piece getPiece() {
        return listPieces.get(0);
    }
}


