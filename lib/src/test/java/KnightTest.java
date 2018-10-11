import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class KnightTest {
    private ConfigBoard config = new ConfigBoard(3, Arrays.asList("knight"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Knight knight = new Knight();
        assertEquals(8, knight.isOccupiedCells(1, 1, board));
    }
}