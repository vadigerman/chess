public class Main {
    public static void main (String[] args) {
        FSM fsm = new FSM();
        BoardCalculator calculator = new BoardCalculator();
        System.out.println(calculator.calculateCombinations(fsm.getBoardSize(), fsm.getConfigPieces()));
    }
}