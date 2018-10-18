import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundQueen extends Piece {
    List<Piece> children = new ArrayList<>();

    public CompoundQueen(Piece... components) {
        setName(ConfigBoard.QUEEN);
        add(components);
    }

    public void add(Piece... components) {
        children.addAll(Arrays.asList(components));
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
