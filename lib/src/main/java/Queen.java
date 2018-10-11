import java.util.List;

public class Queen extends Piece {
    public Queen() {
        setName("queen");
        setOnBoard(false);
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Cell cell = new Cell(-1, -1);
        getOccupiedCells().clear();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == x) || (j == y) || (i - j == x - y) || (i + j == x + y)) {
                    if (!(i == x && j == y)) {
                        cell.setX(i);
                        cell.setY(j);
                        if (!checkCell(board, cell)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
