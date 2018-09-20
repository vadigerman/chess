import java.util.ArrayList;
import java.util.List;

public class BoardCalculator {
    private long countCombinations;

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
        List<Cell> boardOccupiedCells = new ArrayList<Cell>();
        List<Cell> occupiedCells = piece.getOccupiedCells(cell.getX(), cell.getY(), board.getSize());
        for (Cell occupiedCell : occupiedCells) {
            for (Cell boardCell : board.getCells()) {
                if (occupiedCell.getX() == boardCell.getX() && occupiedCell.getY() == boardCell.getY()) {
                    if (boardCell.getState() == CellState.EMPTY) {
                        boardCell.setState(occupiedCell.getState());
                        boardOccupiedCells.add(boardCell);
                    } else if (boardCell.getState() == CellState.CHECKED && occupiedCell.getState() == CellState.BUSY) {
                        boardCell.setState(occupiedCell.getState());
                        boardOccupiedCells.add(boardCell);
                    }
                }
            }
        }
        piece.setBoardOccupiedCells(boardOccupiedCells);
    }

    public void calculateVariables(Board board, ConfigBoard configBoard) {
        if (board.isFreeCell()) {
            Cell cell = board.getFreeCell();
            Piece currentPiece = configBoard.getPiece();
            if (checkCellState(board, currentPiece, cell)) {
                if (configBoard.getListPieces().size() > 1) {
                    putPiece(board, currentPiece, cell);
                    configBoard.updateListPieces();
                    calculateVariables(board, configBoard);
                } else {
                    countCombinations++;
                    board.updateBoard(cell);
                    calculateVariables(board, configBoard);
                }
            } else {
                calculateVariables(board, configBoard);
            }
        } else {

        }
    }

    public void calculateCombinations(ConfigBoard config) {
        Board board = new Board(config.getSizeBoard());
        calculateVariables(board, config);
        board.printBoard();
        System.out.println(countCombinations);
    }
}
