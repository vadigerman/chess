import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QueenTest {
    private ConfigBoard config = new ConfigBoard(4, Arrays.asList("queen"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
        Queen queen = new Queen();
        assertEquals(9, queen.isOccupiedCells(0, 1, board));
    }
}