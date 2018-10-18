public class Main {
    public static void main (String[] args) {
        App app = new App();
        BoardCalculator calculator = new BoardCalculator();
        System.out.println(calculator.calculateCombinations(app.getBoardSize(),app.getAllPieces()));
    }
}