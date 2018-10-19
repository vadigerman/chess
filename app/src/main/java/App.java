import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class App {
    public int getBoardSize () {
        ResourceBundle myBundle = ResourceBundle.getBundle("Labels");
        Scanner sc = new Scanner(System.in);
        System.out.println(myBundle.getString("chessboard_size"));
        int boardLength = sc.nextInt();
        if (boardLength <= 0) {
            System.out.println("count must be a positive number");
            boardLength = getBoardSize();
        }
        return boardLength;
    }

    public int getCountOnePiece (String piece) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter count " + piece + ": ");
        int countPiece = sc.nextInt();
        if (countPiece < 0) {
            System.out.println("count must be a positive number");
            countPiece = getCountOnePiece(piece);
        }
        return countPiece;
    }

    public List<String> getAllPieces () {
        List<String> piecesArr = new ArrayList<String>();
        System.out.println("enter listPieces");
        String[] pieces = {ConfigBoard.QUEEN, ConfigBoard.ROOK, ConfigBoard.BISHOP, ConfigBoard.KING, ConfigBoard.KNIGHT, ConfigBoard.PAWN};
        for (String piece : pieces) {
            int n = getCountOnePiece(piece);
            while (n > 0) {
                piecesArr.add(piece);
                n--;
            }
        }
        return piecesArr;
    }
}
