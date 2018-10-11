import java.util.List;

public class Pawn extends Piece {
    public Pawn() {
        setName("pawn");
        setOnBoard(false);
    }

    public boolean isOccupiedCells(int x, int y, Board board) {
        Cell cell = new Cell(-1, -1);
        getOccupiedCells().clear();
        cell.setX(x - 1);
        cell.setY(y + 1);
        if (!checkCell(board, cell)) {
            return false;
        }
        cell.setX(x + 1);
        cell.setY(y + 1);
        if (!checkCell(board, cell)) {
            return false;
        }
        return true;
    }
}
