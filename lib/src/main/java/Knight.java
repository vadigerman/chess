import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {
    public Knight() {
        setName("knight");
    }

    public static List<Cell> getOccupiedCells(int x, int y) {
        List<Cell> cells = new ArrayList<Cell>();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
                    cells.add(new Cell(i, j, CellState.ATTACKED));
                } else if (i == x && j == y) {
                    cells.add(new Cell(i, j, CellState.BUSY));
                }
            }
        }
        return cells;
    }
}
