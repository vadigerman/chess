import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Board {
    private List<Cell> cells;
    private Map<Integer, Cell> duplicateCells = new HashMap<>();
    private int size;
    private List<Piece> listPieces;
    private Stack<Piece> stackPieces = new Stack<>();

    public Board(ConfigBoard config) {
        this.size = config.getSizeBoard();
        this.cells = createBoard(size);
        this.listPieces = config.getListPieces();
    }

    public Map<Integer, Cell> getDuplicateCells() {
        return duplicateCells;
    }

    public List<Cell> createBoard(int n) {
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Cell cell = new Cell(i, j, CellState.EMPTY);
                cells.add(cell);
                duplicateCells.put(cell.hashCode(), cell);
            }
        }
        return cells;
    }

    public int getSize() {
        return size;
    }

    public List<Cell> getCells() {
        return cells;
    }

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

    public Cell getFreeDuplicateCell() {
        for (Map.Entry<Integer, Cell> entryCell : duplicateCells.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.EMPTY)) {
                cell.setState(CellState.CHECKED);
                return cell;
            }
        }
        return null;
    }

//    public boolean isFreeCell() {
//        List<Cell> cells = getCells();
//        for (Cell cell : cells) {
//            if (cell.getState() == CellState.EMPTY) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean isFreeDuplicateCell() {
        for (Map.Entry<Integer, Cell> entryCell : duplicateCells.entrySet()) {
            if (entryCell.getValue().getState().equals(CellState.EMPTY)) {
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            System.out.println(cell.getX() + "-" + cell.getY() + ": " + cell.getState());
            System.out.println(cell.hashCode());
        }
    }

    public void updateBoard(Cell currentCell) {
        currentCell.setState(CellState.USED);
    }

    public void returnBoardLastState() {
        for (Map.Entry<Integer, Cell> entryCell : duplicateCells.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.USED) || cell.getState().equals(CellState.CHECKED)) {
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
        listPieces.get(1).clearDuplicateClosedCells();
    }

    public Piece getPiece() {
        Piece piece = listPieces.get(0);
//        Map<Integer, Cell> closedCells = piece.getDuplicateClosedCells();
//        for (Map.Entry<Integer, Cell> entryCell : closedCells.entrySet()) {
//            Cell cell = entryCell.getValue();
//            cell.setState(CellState.CHECKED);
//        }
        return piece;
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }
}


