import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class PawnTest {
    private ConfigBoard config = new ConfigBoard(3, Arrays.asList("pawn"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Pawn pawn = new Pawn();
        assertEquals(3, pawn.getOccupiedCells(1, 0, board).size());
    }
}