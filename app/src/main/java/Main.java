public class Main {
    public static void main (String[] args) {
        FSM fsm = new FSM();
        BoardCalculator calculator = new BoardCalculator();
//        final Storage fileStorage = new FileStorage();
        final Storage dbStorage = new DBStorage();

        CalculationListener listener = new CalculationListener() {
            public void onCalculationCompletion(long execTime, long combCnt) {
                dbStorage.saveTime(execTime, combCnt);
            }

            public void onCombinationOccurrence(String path, long cNum) {
//                fileStorage.savePath(path, cNum);
                dbStorage.savePath(path, cNum);
            }
        };
        calculator.addListener(listener);
        calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces());
    }
}