import java.util.List;

public class Main {
    public static void main (String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        App app = new App();
        int boardLength = app.getBoardSize();
        List<String> listPieces = app.getAllPieces();
        BoardCalculator calculator = new BoardCalculator();
        System.out.println(calculator.calculateCombinations(boardLength, listPieces));
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(afterUsedMem);
        System.out.println(beforeUsedMem);
        System.out.println(afterUsedMem - beforeUsedMem);
    }
}