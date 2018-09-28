import java.util.ArrayList;
import java.util.Collections;
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
                    if (boardCell.getState() == CellState.CHECKED && occupiedCell.getState() == CellState.BUSY) {
                        boardCell.setState(occupiedCell.getState());
                        boardOccupiedCells.add(boardCell);
                        piece.addClosedCell(boardCell);
                    } else if (boardCell.getState() == CellState.EMPTY || boardCell.getState() == CellState.CHECKED) {
                        boardCell.setState(occupiedCell.getState());
                        boardOccupiedCells.add(boardCell);
                    }
                }
            }
        }
        piece.setBoardOccupiedCells(boardOccupiedCells);
        piece.setOnBoard(true);
    }

    public void removePiece(Board board, Piece piece) {
        List<Cell> boardOccupiedCells = piece.getBoardOccupiedCells();
        for (Cell occupiedCell : boardOccupiedCells) {
            for (Cell boardCell : board.getCells()) {
                if (occupiedCell.getX() == boardCell.getX() && occupiedCell.getY() == boardCell.getY()) {
                    if (occupiedCell.getState() == CellState.BUSY) {
                        boardCell.setState(CellState.CHECKED);
                    } else {
                        boardCell.setState(CellState.EMPTY);
                    }
                }
            }
        }
        piece.setOnBoard(false);
    }

    public void returnLastState(Piece piece, Board board) {
        List<Cell> closedCells = piece.getClosedCells();
        for (Cell closedCell : closedCells) {
            for (Cell boardCell : board.getCells()) {
                if (closedCell.getX() == boardCell.getX() && closedCell.getY() == boardCell.getY()) {
                    boardCell.setState(CellState.EMPTY);
                }
            }
        }
    }

    public void calculateVariables(Board board, ConfigBoard configBoard) {
        Piece currentPiece = configBoard.getPiece();
        if (currentPiece.getClosedCells() != null) {
            board.addCheckCells(currentPiece.getClosedCells(), CellState.CHECKED);
        }
        if (board.isFreeCell()) {
            Cell cell = board.getFreeCell();
            if (checkCellState(board, currentPiece, cell)) {
                if (configBoard.getListPieces().size() > 1) {
                    putPiece(board, currentPiece, cell);
                    configBoard.pushPiece();
                    board.addCheckCells(currentPiece.getClosedCells(), CellState.ATTACKED);
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
            if (currentPiece.getClosedCells() != null) {
                returnLastState(currentPiece, board);
            }
        }
    }

    public long recursionListPieces(int sizeBoard, List<String> pieces) {
        ConfigBoard config = new ConfigBoard(sizeBoard, pieces);
        Board board = new Board(config.getSizeBoard());
        calculateVariables(board, config);
        return countCombinations;
    }
}
