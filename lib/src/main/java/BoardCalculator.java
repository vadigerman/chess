import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;

    public boolean checkCellState(Board board, Piece piece, Cell currentCell) {
        Map<Integer, Cell> closedCells = piece.getDuplicateClosedCells();
        if (closedCells.get(currentCell.hashCode()) != null) {
            piece.addDuplicateAttackedCells(currentCell, currentCell.hashCode());
            return false;
        }
//        if (piece.getClosedCells() != null) {
//            List<Cell> closedCells = piece.getClosedCells();
//            for (Cell closedCell : closedCells) {
//                if (closedCell.getX() == cell.getX() && closedCell.getY() == cell.getY()) {
//                    return false;
//                }
//            }
//        }
        Map<Integer, Cell> occupiedCells = piece.getOccupiedCells(currentCell.getX(), currentCell.getY(), board);
        for (Map.Entry<Integer, Cell> entryCell : occupiedCells.entrySet()) {
            Cell cell = entryCell.getValue();
            if (cell.getState().equals(CellState.BUSY)) {
                piece.addDuplicateAttackedCells(currentCell, currentCell.hashCode());
                return false;
            }
        }
        return true;
//        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board);
//        for (Cell occupiedCell : occupiedCells) {
//            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
//            if (board.getCells().get(index).getState() == CellState.BUSY) {
//                return false;
//            }
//        }
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
//        List<Cell> boardOccupiedCells = new ArrayList<>();
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
    }

    public void removePiece(Board board, Piece piece) {
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
//        List<Cell> boardOccupiedCells = piece.getBoardOccupiedCells();
//        for (Cell occupiedCell : boardOccupiedCells) {
//            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
//            board.getCells().get(index).setState(CellState.EMPTY);
//            piece.setOnBoard(false);
//        }
    }

    public void calculateVariables(Board board) {
        Piece currentPiece = board.getPiece();
        if (board.isFreeCell()) {
            Cell cell = board.getFreeCell();
            if (checkCellState(board, currentPiece, cell)) {
                if (board.getListPieces().size() > 1) {
                    putPiece(board, currentPiece, cell);
                    board.pushPiece();
                    board.returnBoardLastState();
                    calculateVariables(board);
                } else {
                    countCombinations++;
                    board.updateBoard(cell);
                    calculateVariables(board);
                }
            } else {
                calculateVariables(board);
            }
            if (currentPiece.isOnBoard()) {
                removePiece(board, currentPiece);
                board.popPiece();
                calculateVariables(board);
            }
        } else {
            board.returnBoardLastState();
        }
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
//        long startTime = System.nanoTime();
//        calculateVariables(board);
//        long endTime = System.nanoTime();
//        System.out.println((endTime - startTime) / 1000000);
        return countCombinations / config.getRepetitiveCombinations();
    }
}
