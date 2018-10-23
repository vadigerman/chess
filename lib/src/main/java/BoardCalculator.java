import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;
    private Map<String, Map<Cell, List<Cell>>> cachePiecesOccupiedCells = new HashMap<>();
    private Cell[] arrayCells;

    private List<CalculationListener> listeners = new ArrayList<>();

    public void addListener(CalculationListener listener) {
        this.listeners.add(listener);
    }

    private String getPieceFirstChar(Board board, int i) {
        String piece = board.getPiece(i).getName();
        if (piece.equals(ConfigBoard.KNIGHT)) {
            return "N";
        }
        return String.valueOf(piece.toUpperCase().charAt(0));
    }

    private String createPath(Board board, Cell currentCell) {
        String path = "";
        String str = "";
        String currentChar = "";
        int count = 1;
        for (int i = 0; i < board.getBusyCells().size(); i++) {
            str = getPieceFirstChar(board, i);
            Cell cell = board.getBusyCells().get(i);
            if (str.equals(currentChar)) {
                count++;
            } else {
                count = 1;
            }
            currentChar = str;
            str += Integer.toString(count);
            path += str + Integer.toString(cell.getX()) + Integer.toString(cell.getY()) + ":";
        }
        str = getPieceFirstChar(board, board.getListPieces().size() - 1);
        if (str.equals(currentChar)) {
            str += Integer.toString(count + 1);
        } else {
            str += Integer.toString(1);
        }
        path += str + Integer.toString(currentCell.getX()) + Integer.toString(currentCell.getY()) + "-";
        return path;
    }

    private void createCachePiecesOccupiedCells(Board board) {
        for (Piece piece : board.getListPieces()) {
            if (cachePiecesOccupiedCells.containsKey(piece.getName())) {
                continue;
            }
            Map<Cell, List<Cell>> moves = new HashMap<>();
            for (Cell cell : board.getOriginalCells()) {
                moves.put(cell, piece.calculateOccupiedCells(cell.getX(), cell.getY(), board));
            }
            cachePiecesOccupiedCells.put(piece.getName(), moves);
        }
    }

    private void putPieceOnBoard(boolean canPieceOnBoard, Board board, List<Cell> cells, Cell cell, int level, List<Cell> pieceMove, String pieceName) {
        if (canPieceOnBoard) {
            if (board.getListPieces().size() == level + 1) {
                countCombinations++;
                for(CalculationListener listener : listeners) {
                    listener.onCombinationOccurrence(createPath(board, cell), countCombinations);
                }
            } else {
                Board currentBoard = new Board(board);
                currentBoard.getBusyCells().add(cell);
                List<Cell> _cells = new ArrayList<>(cells);
                _cells.removeAll(pieceMove);
                if (board.getListPieces().get(level + 1).getName().equals(pieceName)) {
                    arrayCells[level + 1] = cell;
                }
                process(currentBoard, _cells, level + 1);
            }
        }
    }

    private void process(Board board, List<Cell> cells, int level) {
        for(Cell cell : cells) {
            if (arrayCells[level] != null && arrayCells[level].compareTo(cell) < 0) {
                continue;
            }
            String pieceName = board.getPiece(level).getName();
            List<Cell> pieceMove = cachePiecesOccupiedCells.get(pieceName).get(cell);
            boolean canPieceOnBoard = true;
            for (Cell c : board.getBusyCells()) {
                if (pieceMove.contains(c)) {
                    canPieceOnBoard = false;
                }
            }
            putPieceOnBoard(canPieceOnBoard, board, cells, cell, level, pieceMove, pieceName);
        }
    }

    private void calculate(Board board) {
        createCachePiecesOccupiedCells(board);
        arrayCells = new Cell[board.getListPieces().size()];
        process(board, board.getOriginalCells(), 0);
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        Board board = new Board(new ConfigBoard(boardLength, listPieces));
        long startTime = System.nanoTime();
        calculate(board);
        long endTime = System.nanoTime();
        System.out.println("calculate time: " + (endTime - startTime) / 1000000);
        for (CalculationListener listener : listeners) {
            listener.onCalculationCompletion((endTime - startTime) / 1000000, countCombinations);
        }
        return countCombinations;
    }
}
