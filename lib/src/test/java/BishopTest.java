import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BishopTest {
    private ConfigBoard config = new ConfigBoard(3, Arrays.asList("bishop"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Bishop bishop = new Bishop();
        assertEquals(5, bishop.getOccupiedCells(1, 1, board).size());
    }
}