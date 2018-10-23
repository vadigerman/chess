import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoardCalculatorTest {
    @Test
    public void calculate_4_kings_3_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(1, boardCalculator.calculateCombinations(3, Arrays.asList("king", "king", "king", "king")));
    }

    @Test
    public void calculate_5_knights_3_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(2, boardCalculator.calculateCombinations(3, Arrays.asList("knight", "knight", "knight", "knight", "knight")));
    }

    @Test
    public void calculate_8_knights_4_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(6, boardCalculator.calculateCombinations(4, Arrays.asList("knight", "knight", "knight", "knight", "knight", "knight", "knight", "knight")));
    }

    @Test
    public void calculate_queen_rook_3_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(16, boardCalculator.calculateCombinations(3, Arrays.asList("queen", "rook")));
    }

    @Test
    public void calculate_rook_bishop_3_boardSize() throws Exception {
        BoardCalculator boardCalculator = new BoardCalculator();
//        assertEquals(24, boardCalculator.calculateCombinations(3, Arrays.asList("rook", "bishop", "knight")));
        TestCalculationListener listener = new TestCalculationListener();
        boardCalculator.addListener(listener);
        boardCalculator.calculateCombinations(4, Arrays.asList("rook", "rook", "bishop", "knight"));
        assertEquals(168, listener.getCombCnt());
        assertEquals((long) listener.getPaths().size(), listener.getCombCnt());
    }

    @Test
    public void calculate_queen_rook_2_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(0, boardCalculator.calculateCombinations(2, Arrays.asList("queen", "rook")));
    }

    @Test
    public void calculate_8_queens_8_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
//        assertEquals(92, boardCalculator.calculateCombinations(8, Arrays.asList("queen", "queen", "queen", "queen", "queen", "queen", "queen", "queen")));
        TestCalculationListener listener = new TestCalculationListener();
        boardCalculator.addListener(listener);
        boardCalculator.calculateCombinations(8, Arrays.asList("queen", "queen", "queen", "queen", "queen", "queen", "queen", "queen"));
        assertEquals(92, listener.getCombCnt());
        assertTrue(listener.getExecTime() < 1000);
        assertEquals((long) listener.getPaths().size(), listener.getCombCnt());
    }

    @Test
    public void calculate_2_queens_2_bishops_2_kings_knight_7_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(3063828, boardCalculator.calculateCombinations(7, Arrays.asList("queen", "queen", "bishop", "bishop", "king", "king", "knight")));
    }

    @Test
    public void calculate_2_bishops_2_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(6, boardCalculator.calculateCombinations(3, Arrays.asList("rook", "rook", "rook")));
    }
}
