import java.util.List;
import java.util.Map;

public class King extends Piece {
    public King() {
        setName("king");
        setOnBoard(false);
    }

    public List<Integer> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
//        List<Cell> cells = new ArrayList<>();
//        attackedCells.clear();
        arrClosedCells.clear();
        for(int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if (!(i == x && j == y)) {
//                        cells.add(new Cell(i, j, CellState.BUSY));
//                    } else {
//                        cells.add(new Cell(i, j, CellState.ATTACKED));
                        putAttackedCell(i, j, board);
                    }
                }
            }
        }
        return arrClosedCells;
    }
}
