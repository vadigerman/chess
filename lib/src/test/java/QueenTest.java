import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class QueenTest {
    private ConfigBoard config = new ConfigBoard(4, Arrays.asList("knight"));
    private Board board = new Board(config);
    private BoardCalculator calculator = new BoardCalculator();
    private Cell cell1 = new Cell(0, 0, CellState.BUSY);

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

    @Test
    public void checkOccupiedCell() throws Exception{
        Queen queen = new Queen();
        Knight knight = new Knight();
        board = calculator.putPieceOnCell(board, cell1, knight);
        assertTrue(queen.checkOccupiedCell(2, 3, board));
    }
}