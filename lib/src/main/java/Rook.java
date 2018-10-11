import java.util.List;

public class Rook extends Piece {
    public Rook() {
        setName("rook");
        setOnBoard(false);
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
        int n = board.getSize();
        Cell cell = new Cell(-1, -1);
        getOccupiedCells().clear();
        for(int i = 0; i < y; i++) {
            cell.setX(x);
            cell.setY(i);
            if (!checkCell(board, cell)) {
                return false;
            }
        }
        for(int i = y + 1; i < n; i++) {
            cell.setX(x);
            cell.setY(i);
            if (!checkCell(board, cell)) {
                return false;
            }
        }
        for(int i = 0; i < x; i++) {
            cell.setX(i);
            cell.setY(y);
            if (!checkCell(board, cell)) {
                return false;
            }
        }
        for(int i = x + 1; i < n; i++) {
            cell.setX(i);
            cell.setY(y);
            if (!checkCell(board, cell)) {
                return false;
            }
        }
        return true;
    }
}
