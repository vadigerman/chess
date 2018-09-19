import java.util.List;

public class BoardCalculator {
    private long countCombinations = 0;

    public boolean checkCellState(Board board, Piece piece, Cell cell) {
        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
        for (Cell occupiedCell : occupiedCells) {
            for (Cell boardCell : board.getCells()) {
                if (occupiedCell.getX() == boardCell.getX()
                        && occupiedCell.getY() == boardCell.getY()
                        && boardCell.getState() == CellState.BUSY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void putPiece(Board board, Piece piece, Cell cell) {
        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
        for (Cell occupiedCell : occupiedCells) {
            for (Cell boardCell : board.getCells()) {
                if (occupiedCell.getX() == boardCell.getX() && occupiedCell.getY() == boardCell.getY()) {
                    if (boardCell.getState() == CellState.EMPTY) {
                        boardCell.setState(occupiedCell.getState());
                    } else if (boardCell.getState() == CellState.CHECKED && occupiedCell.getState() == CellState.BUSY) {
                        boardCell.setState(occupiedCell.getState());
                    }
                }
            }
        }
    }

    public long recurs(Board board, ConfigBoard configBoard) {
        if (board.isFreeCell()) {
            Cell cell = board.getFreeCell();
            Piece currentPiece = configBoard.getPiece();
            if (checkCellState(board, currentPiece, cell)) {
                putPiece(board, currentPiece, cell);
                if (configBoard.getListPieces().size() > 0) {
                    return recurs(board, configBoard);
                }
            }
        }
        return countCombinations;
    }

    public long calculateCombinations(ConfigBoard config) {
        Board board = new Board(config.getSizeBoard());
        countCombinations++;
        if (config.getListPieces().size() > 0) {
        }
        return countCombinations;
    }
}
