import java.util.Collections;
import java.util.List;

public class Piece {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        return Collections.emptyList();
    }

    public void addCellToList(Cell cell, Board board, List<Cell> cellList, int x, int y) {
        cell.setX(x);
        cell.setY(y);
        cellList.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
    }
}
