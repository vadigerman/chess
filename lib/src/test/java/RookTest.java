import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class RookTest {
    private ConfigBoard config = new ConfigBoard(3, Arrays.asList("rook"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Rook rook = new Rook();
        assertEquals(4, rook.isOccupiedCells(1, 1, board));
    }
}