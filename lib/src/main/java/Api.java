import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Api {
//    public static void printArray(Cell[][] arr) {
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr[i].length; j++) {
//                System.out.println(i + "-" + j + ": " + arr[i][j].getState());
//            }
//        }
//    }

//    public static Cell getFreeSquare(Board board) {
//        Cell[][] arr = board.getCells();
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j].getState() == CellState.EMPTY) {
//                    arr[i][j].setX(i);
//                    arr[i][j].setY(j);
//                    System.out.println(i + "-" + j);
//                    return arr[i][j];
//                }
//            }
//        }
//        return null;
//    }

//    public static void updateSquareStatus(Board board) {
//        Cell[][] arr = board.getCells();
//        for(int i = 0; i < arr.length; i++) {
//            for(int j = 0; j < arr[i].length; j++) {
//                if (arr[i][j].getState() == CellState.TEMPORARY) {
//                    arr[i][j].setState(CellState.EMPTY);
//                }
//            }
//        }
//    }

//    public static void checkStateSquare(Board board, Piece piece, Cell cell) {
//        Cell[][] pieceMoves = piece.getOccupiedCell();
//        Cell[][] boardCells = board.getCells();
//        int x = cell.getX() - piece.indexX;
//        int y = cell.getY() - piece.indexY;
//        for(int i = 0; i < pieceMoves.length; i++) {
//            for(int j = 0; j < pieceMoves[i].length; j++) {
//                if ((x + i >= 0)
//                        && (y + j >= 0)
//                        && (x + i < board.getSize())
//                        && (y + j < board.getSize())
//                        && (boardCells[x + i][y + j].getState() == CellState.BUSY)
//                        && (pieceMoves[i][j].getState() == CellState.ATTACKED)) {
//                    cell.setState(CellState.TEMPORARY);
//                    checkStateSquare(board, piece, getFreeSquare(board));
//                }
//            }
//        }
//    }

//    public static String getPiece(Map<String, Integer> mapPieces) {
//        for (Map.Entry<String, Integer> entry : mapPieces.entrySet()) {
//            if (entry.getValue() > 0) {
//                entry.setValue(entry.getValue() - 1);
//                System.out.println(entry.getKey());
//                return entry.getKey();
//            }
//        }
//        return null;
//    }

//    public static Cell[][] updateBoard(Board board, Piece piece, Cell cell) {
//        checkStateSquare(board, piece, cell);
//        Cell[][] pieceMoves = piece.getOccupiedCell();
//        Cell[][] boardCells = board.getCells();
//        int x = cell.getX() - piece.indexX;
//        int y = cell.getY() - piece.indexY;
//        for(int i = 0; i < pieceMoves.length; i++) {
//            for(int j = 0; j < pieceMoves[i].length; j++) {
//                if ((pieceMoves[i][j].getState() != CellState.EMPTY)
//                        && (x + i >= 0)
//                        && (y + j >= 0)
//                        && (x + i < board.getSize())
//                        && (y + j < board.getSize())
//                        && (boardCells[x + i][y + j].getState() == CellState.EMPTY)) {
//                    boardCells[x + i][y + j].setState(pieceMoves[i][j].getState());
//                }
//            }
//        }
//        printArray(boardCells);
//        return boardCells;
//    }

//    public static Piece selectPiece(String pieceName, int boardLength, Cell freeCell) {
//        Piece piece = new Piece();
//        if (pieceName.equals("kings")) {
//            piece = new King();
//        } else if (pieceName.equals("knights")) {
//            piece = new Knight();
//        } else if (pieceName.equals("pawns")) {
//            piece = new Pawn();
//        } else if (pieceName.equals("rooks")) {
//            piece = new Rook(boardLength, freeCell);
//        } else if (pieceName.equals("bishops")) {
//            piece = new Bishop(boardLength, freeCell);
//        } else if (pieceName.equals("queens")) {
//            piece = new Queen(boardLength, freeCell);
//        }
//        return piece;
//    }

    public static void printArrayList(List<String> arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }

    public static void printBoard(Board board) {
        List<Cell> cells = board.getCells();
        for (int i = 0; i < cells.size(); i++) {
            System.out.println(cells.get(i).getX() + "-" + cells.get(i).getY() + ": " + cells.get(i).getState());
        }
    }

    public static void main(int boardLength, List<String> listPieces) {
        Board board = new Board(boardLength);
        printArrayList(listPieces);
        printBoard(board);

//        String pieceName = getPiece(listPieces);
//        Cell freeCell = getFreeSquare(board);
//        while ((freeCell != null) && (pieceName != null)) {
//            updateBoard(board, selectPiece(pieceName, boardLength, freeCell), freeCell);
//            pieceName = getPiece(listPieces);
//            updateSquareStatus(board);
//            freeCell = getFreeSquare(board);
//        }
    }
}
