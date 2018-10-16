import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    public Pawn() {
        setName(ConfigBoard.PAWN);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        addOccupiedCells(cell, x - 1, y + 1, board);
        addOccupiedCells(cell, x + 1, y + 1, board);
    }

    @Override
    protected List<Cell> calculateOccupiedCells2(int x, int y, Board board) {
        List<Cell> result = new ArrayList<>();
        Cell cell = new Cell(-1, -1);
        cell.setX(x - 1);
        cell.setY(y + 1);
        result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
//        addOccupiedCells(cell, x - 1, y + 1, board);
        cell.setX(x + 1);
        cell.setY(y + 1);
        result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
//        addOccupiedCells(cell, x + 1, y + 1, board);
        return result;
    }
}
