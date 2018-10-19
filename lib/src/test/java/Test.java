import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void getOccupiedCells() throws Exception {
        List<Cell> cellList = new ArrayList<>();
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(1, 1);
        Cell cell3 = new Cell(1, 1);
        cellList.add(cell1);
        cellList.add(cell2);
        cell3.setX(0);
        cell3.setY(0);

        List<Integer> f = new ArrayList<>();
        List<Integer> f1 = new ArrayList<>();

        f.add(1);

        f1.add(1);
        f1.add(2);

        System.out.println(f.containsAll(f1));
    }
}
