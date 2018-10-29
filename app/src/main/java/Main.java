import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        FSM fsm = new FSM();
        BoardCalculator calculator = new BoardCalculator();
        final Storage dbStorage = new DBStorage();

        CalculationListener listener = new CalculationListener() {
            private long executionId;
            private List<PiecePaths> piecePaths = new ArrayList<PiecePaths>();

            public void onCalculationCommencement() {
                executionId = dbStorage.registerExecution();
            }

            public void onCombinationOccurrence(String path, long cNum) {
                piecePaths.add(new PiecePaths(executionId, path, cNum));
                if (piecePaths.size() >= 5) {
                    dbStorage.savePath(piecePaths);
                    piecePaths.clear();
                }
            }

            public void onCalculationCompletion(long execTime, long combCnt) {
                dbStorage.updateExecution(executionId, execTime, combCnt);
                dbStorage.savePath(piecePaths);
            }
        };
        calculator.addListener(listener);
        calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces());
    }
}