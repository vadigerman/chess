import java.util.Map;

public class Api {
    public static void printArray(Square[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.println(i + "-" + j + ": " + arr[i][j].getState());
            }
        }
    }

    public static Square getFreeSquare(Board board) {
        Square[][] arr = board.getSquares();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].getState() == SquareState.EMPTY) {
                    arr[i][j].setX(i);
                    arr[i][j].setY(j);
                    System.out.println(i + "-" + j);
                    return arr[i][j];
                }
            }
        }
        return null;
    }

    public static void updateSquareStatus(Board board) {
        Square[][] arr = board.getSquares();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].getState() == SquareState.TEMPORARY) {
                    arr[i][j].setState(SquareState.EMPTY);
                }
            }
        }
    }

    public static void checkStateSquare(Board board, Piece piece, Square square) {
        Square[][] pieceMoves = piece.getOccupiedSquare();
        Square[][] boardSquares = board.getSquares();
        int x = square.getX() - piece.indexX;
        int y = square.getY() - piece.indexY;
        for(int i = 0; i < pieceMoves.length; i++) {
            for(int j = 0; j < pieceMoves[i].length; j++) {
                if ((x + i >= 0)
                        && (y + j >= 0)
                        && (x + i < board.getSize())
                        && (y + j < board.getSize())
                        && (boardSquares[x + i][y + j].getState() == SquareState.BUSY)
                        && (pieceMoves[i][j].getState() == SquareState.ATTACKED)) {
                    square.setState(SquareState.TEMPORARY);
                    checkStateSquare(board, piece, getFreeSquare(board));
                }
            }
        }
    }

    public static String getPiece(Map<String, Integer> mapPieces) {
        for (Map.Entry<String, Integer> entry : mapPieces.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                System.out.println(entry.getKey());
                return entry.getKey();
            }
        }
        return null;
    }

    public static Square[][] updateBoard(Board board, Piece piece, Square square) {
        checkStateSquare(board, piece, square);
        Square[][] pieceMoves = piece.getOccupiedSquare();
        Square[][] boardSquares = board.getSquares();
        int x = square.getX() - piece.indexX;
        int y = square.getY() - piece.indexY;
        for(int i = 0; i < pieceMoves.length; i++) {
            for(int j = 0; j < pieceMoves[i].length; j++) {
                if ((pieceMoves[i][j].getState() != SquareState.EMPTY)
                        && (x + i >= 0)
                        && (y + j >= 0)
                        && (x + i < board.getSize())
                        && (y + j < board.getSize())
                        && (boardSquares[x + i][y + j].getState() == SquareState.EMPTY)) {
                    boardSquares[x + i][y + j].setState(pieceMoves[i][j].getState());
                }
            }
        }
        printArray(boardSquares);
        return boardSquares;
    }

    public static Piece selectPiece(String pieceName, int boardLength, Square freeSquare) {
        Piece piece = new Piece();
        if (pieceName.equals("kings")) {
            piece = new King();
        } else if (pieceName.equals("knights")) {
            piece = new Knight();
        } else if (pieceName.equals("pawns")) {
            piece = new Pawn();
        } else if (pieceName.equals("rooks")) {
            piece = new Rook(boardLength, freeSquare);
        } else if (pieceName.equals("bishops")) {
            piece = new Bishop(boardLength, freeSquare);
        } else if (pieceName.equals("queens")) {
            piece = new Queen(boardLength, freeSquare);
        }
        return piece;
    }

    public static void main(int boardLength, Map<String, Integer> mapPieces) {
        Board board = new Board(boardLength);
        String pieceName = getPiece(mapPieces);
        Square freeSquare = getFreeSquare(board);
        while ((freeSquare != null) && (pieceName != null)) {
            updateBoard(board, selectPiece(pieceName, boardLength, freeSquare), freeSquare);
            pieceName = getPiece(mapPieces);
            updateSquareStatus(board);
            freeSquare = getFreeSquare(board);
        }
    }
}
