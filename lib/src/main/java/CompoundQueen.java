import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundQueen extends Piece {
    private List<Piece> children = new ArrayList<>();

    public CompoundQueen(Rook rook, Bishop bishop) {
        setName(ConfigBoard.QUEEN);
        children.add(rook);
        children.add(bishop);
    }

    protected List<Cell> calculateOccupiedCells(int x, int y, Board board) {
        List<Cell> cellList = new ArrayList<>();
        for (Piece child : children) {
            cellList.addAll(child.calculateOccupiedCells(x, y, board));
        }
        cellList.remove(new Cell(x, y));
        return cellList;
    }
}
