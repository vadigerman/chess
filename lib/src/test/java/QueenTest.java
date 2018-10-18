import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QueenTest {
    private ConfigBoard config = new ConfigBoard(3, Arrays.asList("queen"));
    private Board board = new Board(config);

    @Test
    public void getOccupiedCells() throws Exception {
//        Queen queen = new Queen();
        CompoundQueen queen = new CompoundQueen(
                new Rook(),
                new Bishop()
        );
        assertEquals(9, queen.calculateOccupiedCells(1, 1, board).size());
    }
}