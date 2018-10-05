import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

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
    public void calculate_queen_rook_3_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(16, boardCalculator.calculateCombinations(3, Arrays.asList("queen", "rook")));
    }

    @Test
    public void calculate_8_queens_8_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(92, boardCalculator.calculateCombinations(8, Arrays.asList("queen", "queen", "queen", "queen", "queen", "queen", "queen", "queen")));
    }

    @Test
    public void calculate_2_queens_2_bishops_2_kings_knight_7_boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(3063828, boardCalculator.calculateCombinations(7, Arrays.asList("queen", "queen", "bishop", "bishop", "king", "king", "knight")));
    }

    @Test
    public void calculateCombinations() {
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(0, boardCalculator.calculateCombinations(3, Arrays.asList("rook, knight")).getOccupiedCells().get(0).get().getState());
    }
}