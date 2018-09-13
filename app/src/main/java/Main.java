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

    public static void printArray(Square[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(i + "-" + j + ": " + arr[i][j].isState());
            }
        }
    }

    public static Square getFreeSquare(Square[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].isState()) {
                    arr[i][j].setX(i);
                    arr[i][j].setY(j);
                    return arr[i][j];
                }
            }
        }
        return null;
    }

    public static String getPiece(Map<String, Integer> mapPieces) {
        for (Map.Entry<String, Integer> entry : mapPieces.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                return entry.getKey();
            }
        }
        return null;
    }

    public static Square[][] updateBoard(Board board, Piece piece, Square square) {
        Square[][] pieceMoves = piece.getOccupiedSquare();
        Square[][] boardSquares = board.getSquares();
        int x = square.getX() - piece.indexX;
        int y = square.getY() - piece.indexY;
        for(int i = 0; i < pieceMoves.length; i++) {
            for(int j = 0; j < pieceMoves[i].length; j++) {
                if ((x + i >= 0) && (y + j >= 0)) {
                    boardSquares[x + i][y + j].setState(pieceMoves[i][j].isState());
                }
            }
        }
        printArray(boardSquares);
        return boardSquares;
    }

    public static void main (String[] args) {
        int boardLength = getBoardSize();
        Board board = new Board(boardLength);
        Square freeSquare = getFreeSquare(board.getSquares());
        Map<String, Integer> mapPieces = getAllPieces();
        String pieceName = getPiece(mapPieces);
        if (pieceName.equals("kings")) {
            King king = new King();
            updateBoard(board, king, freeSquare);
        } else if (pieceName.equals("knights")) {
            Knight knight = new Knight();
            updateBoard(board, knight, freeSquare);
        } else if (pieceName.equals("pawns")) {
            Pawn pawn = new Pawn();
            updateBoard(board, pawn, freeSquare);
        }
    }
}