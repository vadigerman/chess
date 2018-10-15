import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Piece {
    private String name;
    private List<Cell> occupiedCells = new ArrayList<>();
    private List<Cell> closedCells = new ArrayList<>();
//    private Map<Cell, CellState> usedCells = new HashMap<>();
//    private List<Cell> listUsedCells = new ArrayList<>();
//    private boolean onBoard;

    public List<Cell> getClosedCells() {
        return closedCells;
    }

    public void clearOccupiedCells() {
        occupiedCells.clear();
    }

    public void addOccupiedCell(Cell cell) {
        occupiedCells.add(cell);
    }

    public List<Cell> getOccupiedCells(int x, int y, Board board) {
        calculateOccupiedCells(x, y, board);
        return occupiedCells;
    }

    protected abstract void calculateOccupiedCells(int x, int y, Board board);

    public void addOccupiedCells(Cell cell, int i, int j, Board board) {
        cell.setX(i);
        cell.setY(j);
        if (board.getCells().contains(cell)) {
            addOccupiedCell(board.getCells().get(board.getCells().indexOf(cell)));
        } else if (board.getBusyCells().contains(cell)) {
            addOccupiedCell(board.getBusyCells().get(board.getBusyCells().indexOf(cell)));
        }
    }

    public void setName(String name) {
        this.name = name;
    }

//    public boolean checkCell(Board board, Cell cell) {
//        if (cell.equals(board.getCells().get(board.getCells().indexOf(cell)))) {
//            if (board.getEmptyCells().get(cell) == CellState.EMPTY || board.getEmptyCells().get(cell) == CellState.CHECKED) {
//                getOccupiedCells().add(board.getCells().get(board.getCells().indexOf(cell)));
//            } else if (board.getBusyCells().get(cell) == CellState.BUSY) {
//                return false;
//            }
//        }
//        return true;
//    }

//    public Map<Cell, CellState> getUsedCells() {
//        return usedCells;
//    }

//    public boolean isOnBoard() {
//        return onBoard;
//    }
//
//    public void setOnBoard(boolean onBoard) {
//        this.onBoard = onBoard;
//    }

//    public boolean isOccupiedCells(int x, int y, Board board) {
//        //List<Cell> cells = new ArrayList<>();
//        // getOccupiedCellsInt(cells);
//        return true;
//    }
}
