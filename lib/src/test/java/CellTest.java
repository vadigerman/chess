import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class CellTest {
    @Test
    public void testCompareTo() throws Exception {
        Cell cell1 = new Cell(0,1);
        Cell cell2 = new Cell(0,2);
        Cell cell3 = new Cell(1,0);
        Cell cell4 = new Cell(1,0);

        assertEquals(-1, cell1.compareTo(cell2));
        assertEquals(1, cell3.compareTo(cell1));
        assertEquals(-1, cell2.compareTo(cell3));
        assertEquals(0, cell4.compareTo(cell3));

        TreeSet<Cell> cells = new TreeSet<>();
        cells.add(cell3);
        cells.add(cell1);
        cells.add(cell2);
        cells.add(cell4);

        Cell[] a = new Cell[] {cell1, cell2, cell3, cell4};

        int i = 0;
        for(Iterator<Cell> iterator = cells.iterator(); iterator.hasNext();) {
            assertEquals(a[i], iterator.next());
            i++;
        }
    }
}
