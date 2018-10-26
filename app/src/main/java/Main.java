import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        FSM fsm = new FSM();
        BoardCalculator calculator = new BoardCalculator();
        final Storage dbStorage = new DBStorage();

        CalculationListener listener = new CalculationListener() {
            private long executionId;
            private List<Object[]> paths = new ArrayList<Object[]>();

            public void onCalculationCommencement() {
                executionId = dbStorage.registerExecution();
            }

            public void onCombinationOccurrence(String path, long cNum) {
                paths.add(new Object[] {executionId, path, cNum});
                if (paths.size() >= 5) {
                    dbStorage.savePath(paths);
                }
                paths.clear();
            }

            public void onCalculationCompletion(long execTime, long combCnt) {
                System.out.println(combCnt);
                dbStorage.updateExecution(executionId, execTime, combCnt);
            }
        };
        calculator.addListener(listener);
        calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces());
    }
}