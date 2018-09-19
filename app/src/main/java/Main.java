import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

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
        System.out.println("enter listPieces");
        String[] pieces = {"queen", "rook", "bishop", "king", "knight", "pawn"};
        for (String piece : pieces) {
            int n = getCountOnePiece(piece);
            while (n > 0) {
                piecesArr.add(piece);
                n--;
            }
        }
        return piecesArr;
    }

    public static Board recurs(Board board) {
        if (board.isFreeCell()) {
            Cell cell = board.getFreeCell();
            return recurs(board);
        } else {
            return board;
        }
    }

    public static void main (String[] args) {
        int boardLength = getBoardSize();
//        List<String> listPieces = getAllPieces();
//        BoardCalculator boardCalculator = new BoardCalculator();
//        long n = boardCalculator.calculateCombinations(new ConfigBoard(boardLength, listPieces));
//        PriorityQueue<String> pieces = new PriorityQueue<String>();
//        Stack<String> stack = new Stack<String>();
        Board board = new Board(boardLength);
        Api.printBoard(recurs(board));


//        pieces.addAll(listPieces);
//        System.out.println(pieces);
    }
}