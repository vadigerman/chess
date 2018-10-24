import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board implements Cloneable {
    private int size;
    private List<Cell> cells;
    private List<Cell> originalCells;
    private List<Cell> busyCells = new ArrayList<>();
    private Map<Cell, String> copyBusyCells = new HashMap<>();
    private List<Piece> listPieces;

    public Board(Board original) {
        this.size = original.size;
        this.cells = new ArrayList<>(original.cells);
        this.originalCells = new ArrayList<>(original.originalCells);
        this.busyCells = new ArrayList<>(original.busyCells);
        this.copyBusyCells = new HashMap<>(original.copyBusyCells);
        this.listPieces = new ArrayList<>(original.listPieces);
    }

    public Board(ConfigBoard config) {
        this.size = config.getSizeBoard();
        this.cells = createBoard();
        this.originalCells = new ArrayList<>(this.cells);
        this.listPieces = config.getListPieces();
    }

    public List<Cell> getOriginalCells() {
        return originalCells;
    }

    private List<Cell> createBoard() {
        int n = getSize();
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Cell cell = new Cell(i, j);
                cells.add(cell);
            }
        }
        return cells;
    }

    public Cell getFreeCell() {
        if (getCells().size() > 0) {
            return getCells().get(0);
        } else {
            return null;
        }
    }

    public Cell nextCell(Cell cell) {
        int i = getCells().indexOf(cell) + 1;
        if (i < getCells().size()) {
            return getCells().get(i);
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

    public Map<Cell, String> getCopyBusyCells() {
        return copyBusyCells;
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
}


