import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> freeCells;
    private List<Cell> occupiedCells;
    private int size;

    public Board(int n) {
        this.size = n;
        this.freeCells = createBoard(size);
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

    public List<Cell> getFreeCells() {
        return freeCells;
    }

    public Cell getFreeCell() {
        List<Cell> cells = getFreeCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.EMPTY) {
                cell.setState(CellState.CHECKED);
                return cell;
            }
        }
        return new Cell(-1, -1, CellState.CHECKED);
    }

    public boolean isFreeCell() {
        List<Cell> cells = getFreeCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.EMPTY) {
                return true;
            }
        }
        return false;
    }

    public void printBoard() {
        List<Cell> cells = getFreeCells();
        for (Cell cell : cells) {
            System.out.println(cell.getX() + "-" + cell.getY() + ": " + cell.getState());
        }
    }

    public void updateBoard(Cell currentCell) {
        int index = currentCell.getX() * size + currentCell.getY();
        getFreeCells().get(index).setState(CellState.USED);
    }

    public void returnBoardLastState() {
        List<Cell> cells = getFreeCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.USED || cell.getState() == CellState.CHECKED) {
                cell.setState(CellState.EMPTY);
            }
        }
    }
}


