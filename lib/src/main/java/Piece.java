import java.util.ArrayList;
import java.util.List;

public class Piece {
    String name;
    List<Cell> boardOccupiedCells;

    public String getName() {
        return name;
    }

    public List<Cell> getBoardOccupiedCells() {
        return boardOccupiedCells;
    }

    public void setBoardOccupiedCells(List<Cell> boardOccupiedCells) {
        this.boardOccupiedCells = boardOccupiedCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cell> getOccupiedCells(int x, int y, int n) {
        List<Cell> cells = new ArrayList<Cell>();
        return cells;
    }
}
