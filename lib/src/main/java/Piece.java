import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Piece {
    private String name;
    private List<Cell> occupiedCells = new ArrayList<>();
    private Map<Cell, CellState> usedCells = new HashMap<>();
    private List<Cell> closedCells = new ArrayList<>();
    private boolean onBoard;

    public boolean isOnBoard() {
        return onBoard;
    }

    public void setOnBoard(boolean onBoard) {
        this.onBoard = onBoard;
    }

    public List<Cell> getClosedCells() {
        return closedCells;
    }

    public Map<Cell, CellState> getUsedCells() {
        return usedCells;
    }

    public List<Cell> getOccupiedCells() {
        return occupiedCells;
    }

    public boolean checkCell(Board board, Cell cell) {
        if (cell.equals(board.getCells().get(board.getCells().indexOf(cell)))) {
            if (board.getEmptyCells().get(cell) == CellState.EMPTY || board.getEmptyCells().get(cell) == CellState.CHECKED) {
                getOccupiedCells().add(board.getCells().get(board.getCells().indexOf(cell)));
            } else if (board.getBusyCells().get(cell) == CellState.BUSY) {
                return false;
            }
        }
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
        //List<Cell> cells = new ArrayList<>();
        // getOccupiedCellsInt(cells);
        return true;
    }
    //protected abstract void getOccupiedCellsInt(List<Cell> cells);
}
