import java.util.List;

public class BoardCalculator {
    private long countCombinations;

    public Cell getCurrentCell(Piece piece, Board board) {
//        Map<Integer, Cell> cellMap = board.getCellMap();
//        for (Map.Entry<Integer, Cell> entryCell : cellMap.entrySet()) {
//            Cell cell = entryCell.getValue();
//            if (cell.getState().equals(CellState.EMPTY)) {
//                Cell currentCell = piece.getDuplicateClosedCells().get(cell.hashCode());
//                if (currentCell == null) {
//                    cell.setState(CellState.CHECKED);
//                    if (checkCellState(board, piece, cell)) {
//                        return cell;
//                    }
//                }
//            } else if (cell.getState().equals(CellState.EMPTY)) {
//                cell.setState(CellState.CHECKED);
//            }
//        }
        return null;
    }

    public boolean checkCellState(Board board, Piece piece, Cell currentCell) {
//        List<Integer> arrOccupiedCells = piece.isOccupiedCells(currentCell.getX(), currentCell.getY(), board);
//        for (Integer arrCell : arrOccupiedCells) {
//            if (board.getCellMap().get(arrCell).getState().equals(CellState.BUSY)) {
//                return false;
//            }
//        }
        return true;
    }

    public void putPiece(Board board, Piece piece, Cell currentCell) {
//        List<Integer> arrOccupiedCells = piece.isOccupiedCells(currentCell.getX(), currentCell.getY(), board);
//        for (Integer arrCell : arrOccupiedCells) {
//            Cell cell = board.getCellMap().get(arrCell);
//            if (cell.getState().equals(CellState.EMPTY) || cell.getState().equals(CellState.CHECKED)) {
//                cell.setState(CellState.ATTACKED);
//                piece.addDuplicateAttackedCells(cell, arrCell);
//                piece.addArrAttackedCells(arrCell);
////                board.getRemovedCells().put(arrCell, cell);
////                board.removeBoardCell(arrCell);
//            }
//        }
//
//        currentCell.setState(CellState.BUSY);
//        piece.addDuplicateClosedCells(currentCell, currentCell.hashCode());
//        piece.addArrClosedCells(currentCell.hashCode());
////        board.getRemovedCells().put(currentCell.hashCode(), currentCell);
////        board.removeBoardCell(currentCell.hashCode());
//        piece.setOnBoard(true);
//        Map<Integer, Cell> attackedCells = piece.getDuplicateAttackedCells();
//        for (Map.Entry<Integer, Cell> entryCell : attackedCells.entrySet()) {
//            Cell cell = entryCell.getValue();
//            if (cell.getState().equals(CellState.CHECKED)) {
//                cell.setState(CellState.EMPTY);
//            }
//        }
    }

    public void removePiece(Piece piece, Cell currentCell) {
//        List<Integer> arrAttCells = piece.getArrAttackedCells();
//        for (Integer attCell : arrAttCells) {
//            board.getCellMap().put(attCell, board.getRemovedCells().get(attCell));
//        }
//        piece.clearArrAttackedCells();
//        int key = piece.getArrClosedCells().get(0);
//        board.getCellMap().get(key).setState(CellState.EMPTY);

//        Map<Integer, Cell> occupiedCells = piece.getDuplicateAttackedCells();
//        for (Map.Entry<Integer, Cell> entryCell : occupiedCells.entrySet()) {
//            entryCell.getValue().setState(CellState.EMPTY);
//        }
//        piece.clearDuplicateAttackedCells();
//        piece.getDuplicateClosedCells().get(currentCell.hashCode()).setState(CellState.EMPTY);
//        piece.setOnBoard(false);
    }

    public void calculateVariables(Board board) {
        Piece currentPiece = board.getPiece();
        Cell cell = board.getFreeCell();
        if (currentPiece.isOccupiedCells(cell.getX(), cell.getY(), board)) {
            if (board.getListPieces().size() > 1) {
                putPieceOnBoard(board, currentPiece, cell);
                board.pushPiece();
                calculateVariables(board);
            } else {
                countCombinations++;
                calculateVariables(board);
            }
        } else {
            board.getEmptyCells().remove(cell);
            board.getEmptyCells().put(cell, CellState.CHECKED);
            calculateVariables(board);
        }
//        Cell currentCell = getCurrentCell(currentPiece, board);
//        if (currentCell != null) {
//            if (board.getListPieces().size() > 1) {
//                putPiece(board, currentPiece, currentCell);
//                board.pushPiece();
////                board.returnBoardLastState();
//                calculateVariables(board);
//            } else {
//                countCombinations++;
////                board.updateBoard(currentCell);
//                calculateVariables(board);
//            }
//            if (currentPiece.isOnBoard()) {
//                removePiece(currentPiece, currentCell);
//                board.popPiece();
//                calculateVariables(board);
//            }
//        } else {
////            board.returnBoardLastState();
//        }
    }

    public void putPieceOnBoard(Board board, Piece piece, Cell cell) {
        board.updateFreeCells(piece.getOccupiedCells());
        board.getEmptyCells().remove(cell);
        board.getEmptyCells().put(cell, CellState.BUSY);
    }


    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
//        long startTime = System.nanoTime();
        calculateVariables(board);
//        long endTime = System.nanoTime();
//        System.out.println("calculate time: " + (endTime - startTime) / 1000000);
        return countCombinations / config.getRepetitiveCombinations();
    }
}
