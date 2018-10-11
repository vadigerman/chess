import java.util.List;

public class Knight extends Piece {
    public Knight() {
        setName("knight");
        setOnBoard(false);
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Cell cell = new Cell(-1, -1);
        getOccupiedCells().clear();
        for(int i = x - 2; i <= x + 2; i++) {
            for (int j = y - 2; j <= y + 2; j++) {
                if (i >= 0 && j >= 0 && i < n && j < n) {
                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
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
