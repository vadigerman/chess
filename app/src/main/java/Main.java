public class Main {
    public static void main (String[] args) {
        FSM fsm = new FSM();
        BoardCalculator calculator = new BoardCalculator();
        final Storage storage = new FileStorage();

        CalculationListener listener = new CalculationListener() {
            public void onCombinationOccurrence(String path, long cNum) {
                storage.save(path, cNum);
            }
            public void onCalculationCompletion(long execTime, long combCnt) { }
        };
        calculator.addListener(listener);
        calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces());
//        FileStorage file = new FileStorage();
//        file.save(fsm.getBoardConfig(), calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces()));
    }
}