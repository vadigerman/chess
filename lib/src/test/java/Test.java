import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

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

//        assertEquals(0, cellList.indexOf(cell1));

//        assertTrue(cell1.equals(cellList.get(cellList.indexOf(cell3))));
//        assertFalse(cell2.equals(cellList.get(cellList.indexOf(cell1))));

//        Set<Cell> set = new HashSet<>();
//        set.add(cell1);
//        set.add(cell2);
//
//        assertEquals(2, set.size());

        List<Integer> f = new ArrayList<>();
        List<Integer> f1 = new ArrayList<>();

        f.add(1);

        f1.add(1);
        f1.add(2);

        System.out.println(f.containsAll(f1));
    }
}
