import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class QueenTest {
    private ConfigBoard config = new ConfigBoard(4, Arrays.asList("king"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Queen queen = new Queen();
        assertEquals(9, queen.getOccupiedCells(0, 1, board).size());
    }

    @Test
    public void checkBoard() throws Exception {
        assertEquals(16, board.getCells().size());
    }

    @Test
    public void checkWRCells() throws Exception {
        assertEquals(16, board.getFreeCells().size());
    }
}