import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells;
    private int size;

    public Board(int n) {
        this.size = n*n;
        List<Cell> cellsList = new ArrayList<Cell>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cellsList.add(new Cell(i, j, CellState.EMPTY));
            }
        }
        this.cells = cellsList;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public Cell getFreeCell() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.EMPTY) {
                cell.setState(CellState.CHECKED);
//                System.out.println("select cell: " + cell.getX() + "-" + cell.getY());
                return cell;
            }
        }
        return new Cell(-1, -1, CellState.INCOMPLETED);
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

    public void printBoard() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            System.out.println(cell.getX() + "-" + cell.getY() + ": " + cell.getState());
        }
    }

    public void updateBoard(Cell currentCell) {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            if (currentCell.getX() == cell.getX() && currentCell.getY() == cell.getY()) {
                cell.setState(CellState.USED);
            }
        }
    }
}


