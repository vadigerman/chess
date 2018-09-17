import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public static List<String> getAllPieces () {
        List<String> piecesArr = new ArrayList<String>();
        System.out.println("enter pieces");
        String[] pieces = {"king", "queen", "rook", "bishop", "knight", "pawn"};
        for (String piece : pieces) {
            int n = getCountOnePiece(piece);
            while (n > 0) {
                piecesArr.add(piece);
                n--;
            }
        }
        return piecesArr;
    }

    public static void main (String[] args) {
        int boardLength = getBoardSize();
        List<String> listPieces = getAllPieces();
        Api.main(boardLength, listPieces);
    }
}