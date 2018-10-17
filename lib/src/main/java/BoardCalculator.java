import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;
    private Map<String, Map<Cell, List<Cell>>> cache = new HashMap<>();
    private Cell[] joe;

    public void calculate(Board board) {
        for(Piece p : board.getListPieces()) {
            if(cache.containsKey(p.getName())) {
                continue;
            }
            Map<Cell, List<Cell>> moves = new HashMap<>();
            for (Cell cell : board.getOriginalCells()) {
                moves.put(cell, p.calculateOccupiedCells(cell.getX(), cell.getY(), board));
            }
            cache.put(p.getName(), moves);
        }
        joe = new Cell[board.getListPieces().size()];
        process2(board, board.getOriginalCells(), 0);
    }

    public void process2(Board board, List<Cell> cells, int level) {
        for(Cell cell : cells) {

            if(joe[level] != null && joe[level].compareTo(cell) < 0) {
                continue;
            }

            Piece piece = board.getPiece(level);
            List<Cell> pieceMove = cache.get(piece.getName()).get(cell);

            boolean can = true;
            for(Cell c : board.getBusyCells()) {
                if(pieceMove.contains(c)) {
                    can = false;
                }
            }

            boolean lastLevel = board.getListPieces().size() == level + 1;
            if(can) {
                if(lastLevel) {
                    countCombinations++;
                } else {
                    Board currentBoard = new Board(board);
                    currentBoard.getBusyCells().add(cell);

                    List<Cell> _cells = new ArrayList<>(cells);
                    _cells.removeAll(pieceMove);
                    if (board.getListPieces().get(level + 1).getName().equals(piece.getName())) {
                        joe[level + 1] = cell;
                    }
                    process2(currentBoard, _cells, level + 1);
                }
            }
        }
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
        long startTime = System.nanoTime();
        calculate(board);
        long endTime = System.nanoTime();
        System.out.println("calculate time: " + (endTime - startTime) / 1000000);
        System.out.println(countCombinations);
        return countCombinations;
    }
}
