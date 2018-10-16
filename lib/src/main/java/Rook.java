import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook() {
        setName(ConfigBoard.ROOK);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
//        clearOccupiedCells();
//        Cell cell = new Cell(-1, -1);
//        int n = board.getSize();
//        for(int i = 0; i < y; i++) {
//            addOccupiedCells(cell, x, i, board);
//        }
//        for(int i = y + 1; i < n; i++) {
//            addOccupiedCells(cell, x, i, board);
//        }
//        for(int i = 0; i < x; i++) {
//            addOccupiedCells(cell, i, y, board);
//        }
//        for(int i = x + 1; i < n; i++) {
//            addOccupiedCells(cell, i, y, board);
//        }
    }

    @Override
    protected List<Cell> calculateOccupiedCells2(int x, int y, Board board) {
        List<Cell> result = new ArrayList<>();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for(int i = 0; i < y; i++) {
//            addOccupiedCells(cell, x, i, board);
            cell.setX(x);
            cell.setY(i);
            result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
        }
        for(int i = y + 1; i < n; i++) {
//            addOccupiedCells(cell, x, i, board);
            cell.setX(x);
            cell.setY(i);
            result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
        }
        for(int i = 0; i < x; i++) {
//            addOccupiedCells(cell, i, y, board);
            cell.setX(i);
            cell.setY(y);
            result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
        }
        for(int i = x + 1; i < n; i++) {
//            addOccupiedCells(cell, i, y, board);
            cell.setX(i);
            cell.setY(y);
            result.add(board.getOriginalCells().get(board.getOriginalCells().indexOf(cell)));
        }
        return result;
    }
}
