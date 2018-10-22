public class Main {
    public static void main (String[] args) {
        FSM fsm = new FSM();
        BoardCalculator calculator = new BoardCalculator();
//        File file = new File();
//        file.save(fsm.getBoardConfig(), calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces()));
        System.out.println(fsm.getBoardConfig());
        System.out.println(calculator.calculateCombinations(fsm.getBoardSize(), fsm.getListPieces()));
    }
}