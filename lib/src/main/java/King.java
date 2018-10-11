import java.util.List;

public class King extends Piece {
    public King() {
        setName("king");
        setOnBoard(false);
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Cell cell = new Cell(-1, -1);
        getOccupiedCells().clear();
        for(int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
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
