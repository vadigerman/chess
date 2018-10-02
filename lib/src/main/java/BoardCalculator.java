import java.util.ArrayList;
import java.util.List;

public class BoardCalculator {
    private long countCombinations;

    public boolean checkCellState(Board board, Piece piece, Cell cell) {
        if (piece.getClosedCells() != null) {
            List<Cell> closedCells = piece.getClosedCells();
            for (Cell closedCell : closedCells) {
                if (closedCell.getX() == cell.getX() && closedCell.getY() == cell.getY()) {
                    return false;
                }
            }
        }
        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
        for (Cell occupiedCell : occupiedCells) {
            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
            if (board.getFreeCells().get(index).getState() == CellState.BUSY) {
                return false;
            }
        }
        return true;
    }

    public void putPiece(Board board, Piece piece, Cell cell) {
        List<Cell> boardOccupiedCells = new ArrayList<Cell>();
        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
        for (Cell occupiedCell : occupiedCells) {
            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
            Cell boardCell = board.getFreeCells().get(index);
            if (boardCell.getState() == CellState.CHECKED && occupiedCell.getState() == CellState.BUSY) {
                boardCell.setState(occupiedCell.getState());
                boardOccupiedCells.add(boardCell);
                piece.addClosedCell(boardCell);
            } else if (boardCell.getState() == CellState.EMPTY || boardCell.getState() == CellState.CHECKED) {
                boardCell.setState(occupiedCell.getState());
                boardOccupiedCells.add(boardCell);
            }
        }
        piece.setBoardOccupiedCells(boardOccupiedCells);
        piece.setOnBoard(true);
    }

    public void removePiece(Board board, Piece piece) {
        List<Cell> boardOccupiedCells = piece.getBoardOccupiedCells();
        for (Cell occupiedCell : boardOccupiedCells) {
            int index = occupiedCell.getX() * board.getSize() + occupiedCell.getY();
            board.getFreeCells().get(index).setState(CellState.EMPTY);
            piece.setOnBoard(false);
        }
    }

    public void calculateVariables(Board board, ConfigBoard configBoard) {
        Piece currentPiece = configBoard.getPiece();
        if (board.isFreeCell()) {
            Cell cell = board.getFreeCell();
            if (checkCellState(board, currentPiece, cell)) {
                if (configBoard.getListPieces().size() > 1) {
                    putPiece(board, currentPiece, cell);
                    configBoard.pushPiece();
                    board.returnBoardLastState();
                    calculateVariables(board, configBoard);
                } else {
                    countCombinations++;
                    board.updateBoard(cell);
                    calculateVariables(board, configBoard);
                }
            } else {
                calculateVariables(board, configBoard);
            }
            if (currentPiece.isOnBoard()) {
                removePiece(board, currentPiece);
                configBoard.popPiece();
                calculateVariables(board, configBoard);
            }
        } else {
            board.returnBoardLastState();
        }
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config.getSizeBoard());
        long startTime = System.nanoTime();
        calculateVariables(board, config);
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);
        return countCombinations / config.getRepetitiveCombinations();
    }
}
