import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Api {
    public static void printArrayList(List<String> arrList) {
        for (String item : arrList) {
            System.out.println(item);
        }
    }

    public static void printBoard(Board board) {
        List<Cell> cells = board.getCells();
        for (Cell cell : cells) {
            System.out.println(cell.getX() + "-" + cell.getY() + ": " + cell.getState());
        }
    }

//    public static Piece selectPiece(String pieceName) {
//        Piece piece = new Piece();
//        if (pieceName.equals("king")) {
//            piece = new King();
//        } else if (pieceName.equals("knight")) {
//            piece = new Knight();
//        } else if (pieceName.equals("pawn")) {
//            piece = new Pawn();
//        } else if (pieceName.equals("rook")) {
//            piece = new Rook();
//        } else if (pieceName.equals("bishop")) {
//            piece = new Bishop();
//        } else if (pieceName.equals("queen")) {
//            piece = new Queen();
//        }
//        return piece;
//    }

//    public static Cell getFreeCell(Board board) {
//        List<Cell> cells = board.getCells();
//        for (Cell cell : cells) {
//            if (cell.getState() == CellState.EMPTY) {
//                cell.setState(CellState.CHECKED);
//                System.out.println("select cell: " + cell.getX() + "-" + cell.getY());
//                return cell;
//            }
//        }
//        System.out.println("lose");
//        return new Cell(-1, -1, CellState.INCOMPLETED);
//    }

    public static void updateBoard(Board board) {
        List<Cell> cells = board.getCells();
        int i = 0;
        while (cells.get(i).getState() != CellState.CHECKED) {
            i++;
        }
        cells.get(i).setState(CellState.ATTACKED);
    }

    public static String getPiece(List<String> pieces) {
        if (pieces.size() > 0) {
            String piece = pieces.get(0);
            pieces.remove(0);
            System.out.println("select piece: " + piece);
            return piece;
        }
        return "no listPieces";
    }

//    public static boolean checkStateCell(Board board, Piece piece, Cell cell) {
//        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
//        for (Cell occupiedCell : occupiedCells) {
//            for (Cell boardCell : board.getCells()) {
//                if (occupiedCell.getX() == boardCell.getX()
//                        && occupiedCell.getY() == boardCell.getY()
//                        && boardCell.getState() == CellState.BUSY) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    public static void putPiece(Board board, Piece piece, Cell cell) {
//        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
//        for (Cell occupiedCell : occupiedCells) {
//            for (Cell boardCell : board.getCells()) {
//                if (occupiedCell.getX() == boardCell.getX() && occupiedCell.getY() == boardCell.getY()) {
//                    if (boardCell.getState() == CellState.EMPTY) {
//                        boardCell.setState(occupiedCell.getState());
//                    } else if (boardCell.getState() == CellState.CHECKED && occupiedCell.getState() == CellState.BUSY) {
//                        boardCell.setState(occupiedCell.getState());
//                    }
//                }
//            }
//        }
//    }

    public static void main(int boardLength, List<String> listPieces) {
//        Stack<String> stackPieces = new Stack<String>();
//        String currentPiece;
//        Board board = new Board(boardLength);
//        printArrayList(listPieces);
//        List<String> uncheckPieces = new ArrayList<String>();
//        Cell freeCell = board.getFreeCell();
//        while (freeCell.getState() != CellState.COMPLETED && freeCell.getState() != CellState.INCOMPLETED) {
//            boolean handler = true;
//            while (listPieces.size() > 0 && handler) {
//                currentPiece = getPiece(listPieces);
//                Piece piece = selectPiece(currentPiece);
//                if (checkStateCell(board, piece, freeCell)) {
//                    putPiece(board, piece, freeCell);
//                    stackPieces.push(currentPiece);
//                    handler = false;
//                } else {
//                    uncheckPieces.add(currentPiece);
//                }
//            }
//            if (handler) {
//                updateBoard(board);
//            } else {
//                listPieces.addAll(uncheckPieces);
//                uncheckPieces.clear();
//            }
//            printBoard(board);
//            freeCell = board.getFreeCell();
//            if (listPieces.size() == 0 && !handler) {
//                freeCell.setState(CellState.COMPLETED);
//            } else {
//                listPieces.addAll(uncheckPieces);
//                uncheckPieces.clear();
//            }
//        }
//        if (freeCell.getState() == CellState.COMPLETED) {
//            System.out.println("win");
//            System.out.println(stackPieces);
//        }
    }
}