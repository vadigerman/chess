import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;

//    public void removePiece(Piece piece, Cell currentCell, Board board) {
//        for (Map.Entry<Cell, CellState> entryCell : piece.getUsedCells().entrySet()) {
//            board.getEmptyCells().put(entryCell.getKey(), CellState.EMPTY);
//        }
//        board.getEmptyCells().put(currentCell, CellState.EMPTY);
//        piece.getClosedCells().add(currentCell);
//        board.getBusyCells().remove(currentCell);
//        piece.setOnBoard(false);
//    }

//    public void calculateVariables(Board board) {
//        Piece currentPiece = board.getPiece();
//        board.updateClosedCells(currentPiece);
//        Cell cell = board.getFreeCell();
//        if (cell != null) {
//            if (currentPiece.isOccupiedCells(cell.getX(), cell.getY(), board)) {
//                if (board.getListPieces().size() > 1) {
//                    board.removeClosedCells(currentPiece);
//                    putPieceOnBoard(board, currentPiece, cell);
//                    board.pushPiece();
//                    calculateVariables(board);
//                } else {
//                    countCombinations++;
//                    board.getEmptyCells().remove(cell);
//                    currentPiece.getUsedCells().put(cell, CellState.USED);
//                    calculateVariables(board);
//                }
//            } else {
//                board.getEmptyCells().remove(cell);
//                currentPiece.getUsedCells().put(cell, CellState.CHECKED);
//                board.getEmptyCells().put(cell, CellState.CHECKED);
//                calculateVariables(board);
//            }
//            if (currentPiece.isOnBoard()) {
//                removePiece(currentPiece, cell, board);
//                board.popPiece();
//                calculateVariables(board);
//            }
//        } else {
//            board.returnLastState(currentPiece);
//        }
//    }

    public void calculate(Board board) {
        process(board, board.getFreeCell(), 0);
    }

    public void process(Board board, Cell cell, int level) {
        while((cell = board.getFreeCell()) != null) {
            Piece piece = board.getPiece(level);
            // put piece on the board
            boolean b = putPieceOnBoard(board, piece, cell);
            boolean last = board.getListPieces().size() == level + 1;
            if(b) {
                if(last) {
                    countCombinations++;
                } else {
                    Board _b = new Board(board);
                    level++;
//                    _b.getEmptyCells().keySet().removeAll(p.getOccupiedCells());
//                    _b.getEmptyCells().keySet().remove(cell);
//                    _b.getBusyCells().put(cell, CellState.BUSY);
                    process(_b, board.getFreeCell(), level);
                }
            } else {
                board.getCells().remove(cell);
            }
        }
    }

    public boolean putPieceOnBoard(Board board, Piece piece, Cell cell) {
//        board.updateFreeCells(piece.getOccupiedCells(), piece);
//        board.getEmptyCells().remove(cell);
//        board.getBusyCells().put(cell, CellState.BUSY);
//        piece.setOnBoard(true);
        for (Cell occupiedCell : piece.getOccupiedCells(cell.getX(), cell.getY(), board)) {
            boolean b = board.getBusyCells().contains(occupiedCell);
            if (b) {
                return false;
            } else {
                board.getCells().remove(occupiedCell);
            }
        }
        board.getBusyCells().add(cell);
        board.getCells().remove(cell);
        return true;
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
        long startTime = System.nanoTime();
        calculate(board);
        long endTime = System.nanoTime();
        System.out.println("calculate time: " + (endTime - startTime) / 1000000);
        return countCombinations / config.getRepetitiveCombinations();
    }
}
