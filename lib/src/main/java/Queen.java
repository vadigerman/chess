import java.util.List;
import java.util.Map;

public class Queen extends Piece {
    public Queen() {
        setName("queen");
        setOnBoard(false);
    }

    public List<Integer> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
//        List<Cell> cells = new ArrayList<>();
//        attackedCells.clear();
        arrClosedCells.clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == x) || (j == y) || (i - j == x - y) || (i + j == x + y)) {
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
