import java.util.List;

public class Main {
    public static void main (String[] args) {
        App app = new App();
        int boardLength = app.getBoardSize();
        List<String> listPieces = app.getAllPieces();
        BoardCalculator calculator = new BoardCalculator();
        System.out.println(calculator.calculateCombinations(boardLength, listPieces));
    }
}