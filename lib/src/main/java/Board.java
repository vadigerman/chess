import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Cell> cells;
    private int size;

    public Board(int n) {
        this.size = n;
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
                return cell;
            }
        }
        return new Cell(-1, -1, CellState.CHECKED);
    }

    public Cell getCellForFirstPiece() {
        List<Cell> cells = getCells();
        if (getSize() % 2 == 1) {
            for (int i = 0; i < getSize()/2; i++) {
                if (cells.get(i).getState() == CellState.EMPTY) {
                    cells.get(i).setState(CellState.CHECKED);
                    return cells.get(i);
                }
            }
        }
        return new Cell(-1, -1, CellState.CHECKED);
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

    public void returnBoardLastState() {
        List<Cell> cells = getCells();
        for (Cell cell : cells) {
            if (cell.getState() == CellState.USED || cell.getState() == CellState.CHECKED) {
                cell.setState(CellState.EMPTY);
            }
        }
    }

//    public void boardNextState() {
//        List<Cell> cells = getCells();
//        for (Cell cell : cells) {
//            if (cell.getState() == CellState.CHECKED) {
//                cell.setState(CellState.ATTACKED);
//            }
//        }
//    }

    public void addCheckCells(List<Cell> cells, CellState cellState) {
        List<Cell> boardCells = getCells();
        for (Cell checkCell : cells) {
            for (Cell boardCell : boardCells) {
                if (checkCell.getX() == boardCell.getX() && checkCell.getY() == boardCell.getY() &&
                        (boardCell.getState() == CellState.EMPTY || boardCell.getState() == CellState.CHECKED)) {
                    boardCell.setState(cellState);
                }
            }
        }
    }
}


