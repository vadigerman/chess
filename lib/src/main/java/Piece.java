import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Piece {
    private String name;
    protected List<Cell> occupiedCells = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void clearOccupiedCells() {
        occupiedCells.clear();
    }

    public void addOccupiedCell(Cell cell) {
        occupiedCells.add(cell);
    }

    public List<Cell> getOccupiedCells(int x, int y, Board board) {
        return calculateOccupiedCells2(x, y, board);
        //return occupiedCells;
    }

    protected List<Cell> calculateOccupiedCells2(int x, int y, Board board) {
        return Collections.emptyList();
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
}
