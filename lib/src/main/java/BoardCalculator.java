import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;

//    public boolean checkCellState(Board board, Piece piece, Cell cell) {
//        if (piece.getClosedCells() != null) {
//            List<Cell> closedCells = piece.getClosedCells();
//            for (Cell closedCell : closedCells) {
//                if (closedCell.getX() == cell.getX() && closedCell.getY() == cell.getY()) {
//                    return false;
//                }
//            }
//        }
//        Map<Integer, WeakReference<Cell>> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board);
////        for (Cell occupiedCell : occupiedCells) {
////            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
////            if (board.getCells().get(index).getState() == CellState.BUSY) {
////                return false;
////            }
////        }
//        return true;
//    }

//    public void putPiece(Board board, Piece piece, Cell cell) {
//        List<Cell> boardOccupiedCells = new ArrayList<>();
//        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board);
//        for (Cell occupiedCell : occupiedCells) {
//            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
//            Cell boardCell = board.getCells().get(index);
//            if (boardCell.getState() == CellState.CHECKED && occupiedCell.getState() == CellState.BUSY) {
//                boardCell.setState(occupiedCell.getState());
//                boardOccupiedCells.add(boardCell);
//                piece.addClosedCell(boardCell);
//            } else if (boardCell.getState() == CellState.EMPTY || boardCell.getState() == CellState.CHECKED) {
//                boardCell.setState(occupiedCell.getState());
//                boardOccupiedCells.add(boardCell);
//            }
//        }
//        piece.setBoardOccupiedCells(boardOccupiedCells);
//        piece.setOnBoard(true);
//    }

//    public void removePiece(Board board, Piece piece) {
//        List<Cell> boardOccupiedCells = piece.getBoardOccupiedCells();
//        for (Cell occupiedCell : boardOccupiedCells) {
//            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
//            board.getCells().get(index).setState(CellState.EMPTY);
//            piece.setOnBoard(false);
//        }
//    }

//    public void calculateVariables(Board board, ConfigBoard configBoard) {
//        Piece currentPiece = board.getPiece();
//        if (board.isFreeCell()) {
//            Cell cell = board.getFreeCell();
//            if (checkCellState(board, currentPiece, cell)) {
//                if (configBoard.getListPieces().size() > 1) {
//                    putPiece(board, currentPiece, cell);
//                    board.pushPiece();
//                    board.returnBoardLastState();
//                    calculateVariables(board, configBoard);
//                } else {
//                    countCombinations++;
//                    board.updateBoard(cell);
//                    calculateVariables(board, configBoard);
//                }
//            } else {
//                calculateVariables(board, configBoard);
//            }
//            if (currentPiece.isOnBoard()) {
//                removePiece(board, currentPiece);
//                board.popPiece();
//                calculateVariables(board, configBoard);
//            }
//        } else {
//            board.returnBoardLastState();
//        }
//    }

    public Board putPieceOnCell(Board board, Cell cell, Piece currentPiece) {
        Map<Integer, WeakReference<Cell>> occupiedWRCells = currentPiece.getOccupiedCells(cell.getX(), cell.getY(), board);
        for (Map.Entry<Integer, WeakReference<Cell>> entry : occupiedWRCells.entrySet()) {
            WeakReference<Cell> wrCell = entry.getValue();
            board.replaceReferenceFreeCellByOccupied(wrCell, currentPiece);
        }
        board.updateBusyCell(cell, CellState.BUSY, currentPiece);
        board.pushPiece();
        currentPiece.setOnBoard(true);
        return board;
    }

    public void mainFunction(Board board) {
        Piece currentPiece = board.getPiece();
        if (board.getFreeCells().size() > 0) {
            WeakReference<Cell> wrCell = board.getWRFreeCell();
            Cell cell = wrCell.get();
            if (currentPiece.checkOccupiedCell(cell.getX(), cell.getY(), board)) {
                if (board.getListPieces().size() > 1) {
                    putPieceOnCell(board, cell, currentPiece);
                    mainFunction(board);
                } else {
                    countCombinations++;
                    board.updateBusyCell(cell, CellState.ATTACKED, currentPiece);
                    mainFunction(board);
                }
            } else {
                board.updateBusyCell(cell, CellState.ATTACKED, currentPiece);
                mainFunction(board);
            }
            if (currentPiece.isOnBoard()) {
                board.removePiece(currentPiece);
                board.popPiece();
                mainFunction(board);
            }
        } else {
            board.returnBoardLastState(currentPiece);
        }
    }

    public Board calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
        mainFunction(board);
//        long startTime = System.nanoTime();
//        calculateVariables(board, config);
//        long endTime = System.nanoTime();
//        System.out.println((endTime - startTime) / 1000000);
//        return countCombinations / config.getRepetitiveCombinations();
        return board;
    }
}
