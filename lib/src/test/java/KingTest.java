import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class KingTest {
    private ConfigBoard config = new ConfigBoard(3, Arrays.asList("king"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        King king = new King();
        assertEquals(9, king.getOccupiedCells(1, 1, board).size());
    }
}