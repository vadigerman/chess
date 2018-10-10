import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;

    public Cell getCurrentCell(Piece piece, Board board) {
        Map<Integer, Cell> cellMap = board.getDuplicateCells();
        for (Map.Entry<Integer, Cell> entryCell : cellMap.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.EMPTY)) {
                Cell currentCell = piece.getDuplicateClosedCells().get(cell.hashCode());
                if (currentCell == null) {
                    cell.setState(CellState.CHECKED);
                    if (checkCellState(board, piece, cell)) {
                        return cell;
                    }
                }
            } else if (cell.getState().equals(CellState.EMPTY)) {
                cell.setState(CellState.CHECKED);
            }
        }
        return null;
    }

    public boolean checkCellState(Board board, Piece piece, Cell currentCell) {
//        Map<Integer, Cell> closedCells = piece.getDuplicateClosedCells();
//        if (closedCells.get(currentCell.hashCode()) != null) {
//            return false;
//        }
        List<Integer> arrOccupiedCells = piece.getArrClosedCells();
        for (Integer arrCell : arrOccupiedCells) {
            if (board.getDuplicateCells().get(arrCell).getState().equals(CellState.BUSY)) {
                return false;
            }
        }

//        Map<Integer, Cell> occupiedCells = piece.getOccupiedCells(currentCell.getX(), currentCell.getY(), board);
//        for (Map.Entry<Integer, Cell> entryCell : occupiedCells.entrySet()) {
//            Cell cell = entryCell.getValue();
//            if (cell.getState().equals(CellState.BUSY)) {
//                return false;
//            }
//        }
        return true;
    }

    public void putPiece(Board board, Piece piece, Cell currentCell) {
        Map<Integer, Cell> occupiedCells = piece.getOccupiedCells(currentCell.getX(), currentCell.getY(), board);
        for (Map.Entry<Integer, Cell> entryCell : occupiedCells.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.EMPTY) || cell.getState().equals(CellState.CHECKED)) {
                cell.setState(CellState.ATTACKED);
                piece.addDuplicateAttackedCells(cell, entryCell.getKey());
            }
        }
        currentCell.setState(CellState.BUSY);
        piece.addDuplicateClosedCells(currentCell, currentCell.hashCode());
        piece.setOnBoard(true);
        Map<Integer, Cell> attackedCells = piece.getDuplicateAttackedCells();
        for (Map.Entry<Integer, Cell> entryCell : attackedCells.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.CHECKED)) {
                cell.setState(CellState.EMPTY);
            }
        }
    }

    public void removePiece(Piece piece) {
        Map<Integer, Cell> occupiedCells = piece.getDuplicateAttackedCells();
        for (Map.Entry<Integer, Cell> entryCell : occupiedCells.entrySet()) {
            entryCell.getValue().setState(CellState.EMPTY);
        }
        piece.clearDuplicateAttackedCells();
        Map<Integer, Cell> closedCells = piece.getDuplicateClosedCells();
        for (Map.Entry<Integer, Cell> entryCell : closedCells.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.BUSY)) {
                cell.setState(CellState.EMPTY);
            }
        }
        piece.setOnBoard(false);
    }

    public void calculateVariables(Board board) {
        Piece currentPiece = board.getPiece();
        Cell currentCell = getCurrentCell(currentPiece, board);
        if (currentCell != null) {
            if (board.getListPieces().size() > 1) {
                putPiece(board, currentPiece, currentCell);
                board.pushPiece();
                board.returnBoardLastState();
                calculateVariables(board);
            } else {
                countCombinations++;
                board.updateBoard(currentCell);
                calculateVariables(board);
            }
            if (currentPiece.isOnBoard()) {
                removePiece(currentPiece);
                board.popPiece();
                calculateVariables(board);
            }
        } else {
            board.returnBoardLastState();
        }

//        if (board.isFreeDuplicateCell()) {
//            Cell cell = board.getFreeCell();
//            Cell cell = board.getFreeDuplicateCell();
//            if (checkCellState(board, currentPiece, cell)) {
//                if (board.getListPieces().size() > 1) {
//                    putPiece(board, currentPiece, cell);
//                    board.pushPiece();
//                    board.returnBoardLastState();
//                    calculateVariables(board);
//                } else {
//                    countCombinations++;
//                    board.updateBoard(cell);
//                    calculateVariables(board);
//                }
//            } else {
//                calculateVariables(board);
//            }
//            if (currentPiece.isOnBoard()) {
//                removePiece(currentPiece);
//                board.popPiece();
//                calculateVariables(board);
//            }
//        } else {
//            board.returnBoardLastState();
//        }
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
        long startTime = System.nanoTime();
        calculateVariables(board);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
        return countCombinations / config.getRepetitiveCombinations();
    }
}
