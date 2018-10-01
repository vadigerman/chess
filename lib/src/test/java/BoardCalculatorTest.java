import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class BoardCalculatorTest {
    @Test
    public void calculate4Kings3boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(1, boardCalculator.calculateCombinations(3, Arrays.asList("king", "king", "king", "king")));
    }

    @Test
    public void calculate5Knights3boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(2, boardCalculator.calculateCombinations(3, Arrays.asList("knight", "knight", "knight", "knight", "knight")));
    }

    @Test
    public void calculateQueenRook3boardSize() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(16, boardCalculator.calculateCombinations(3, Arrays.asList("queen", "rook")));
    }

    @Test
    public void calculateTests() throws Exception{
        BoardCalculator boardCalculator = new BoardCalculator();
        assertEquals(0, boardCalculator.calculateCombinations(2, Arrays.asList("queen", "rook")));
    }
}
