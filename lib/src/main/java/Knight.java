import java.util.List;
import java.util.Map;

public class Knight extends Piece {
    public Knight() {
        setName("knight");
        setOnBoard(false);
    }

    public List<Integer> getOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
//        List<Cell> cells = new ArrayList<>();
//        attackedCells.clear();
        arrClosedCells.clear();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
//                        cells.add(new Cell(i, j, CellState.ATTACKED));
                        putAttackedCell(i, j, board);
//                    } else if (i == x && j == y) {
//                        cells.add(new Cell(i, j, CellState.BUSY));
                    }
                }
            }
        }
        return arrClosedCells;
    }
}
