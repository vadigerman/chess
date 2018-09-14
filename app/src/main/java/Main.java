import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static int getBoardSize () {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count chessboard's rows/columns (count rows = count columns): ");
        int boardLength = sc.nextInt();
        if (boardLength <= 0) {
            System.out.println("count must be a positive number");
            boardLength = getBoardSize();
        }
        return boardLength;
    }

    public static int getCountOnePiece (String piece) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count " + piece + ": ");
        int countPiece = sc.nextInt();
        if (countPiece < 0) {
            System.out.println("count must be a positive number");
            countPiece = getCountOnePiece(piece);
        }
        return countPiece;
    }

    public static Map<String, Integer> getAllPieces () {
        Map<String, Integer> mapPieces = new HashMap<String, Integer>();
        System.out.println("enter pieces");
        String[] pieces = {"kings", "queens", "rooks", "bishops", "knights", "pawns"};
        for (String piece : pieces) {
            mapPieces.put(piece, getCountOnePiece(piece));
        }
        return mapPieces;
    }

    public static void main (String[] args) {
        int boardLength = getBoardSize();
        Map<String, Integer> mapPieces = getAllPieces();
        Api.main(boardLength, mapPieces);
    }
}