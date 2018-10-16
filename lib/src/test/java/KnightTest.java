import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class KnightTest {
    private ConfigBoard config = new ConfigBoard(4, Arrays.asList("knight"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Knight knight = new Knight();
        assertEquals(4, knight.getOccupiedCells(1, 1, board).size());
    }
}