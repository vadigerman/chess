import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardCalculator {
    private long countCombinations;
    private Map<String, Map<Cell, List<Cell>>> cache = new HashMap<>();

    public void calculate(Board board) {
        long startTime = System.nanoTime();

        for(Piece p : board.getListPieces()) {
            if(cache.containsKey(p.getName())) {
                continue;
            }
            Map<Cell, List<Cell>> moves = new HashMap<>();
            for (Cell cell : board.getOriginalCells()) {
                moves.put(cell, p.calculateOccupiedCells2(cell.getX(), cell.getY(), board));
            }
            cache.put(p.getName(), moves);
        }
        long endTime = System.nanoTime();
        System.out.println("caching time: " + (endTime - startTime) / 1000000);

        process(board, board.getFreeCell(), board.getPiece(0), 0);
    }

    public void process(Board board, Cell cell, Piece piece, int level) {
        while(cell != null) {
            boolean lastLevel = board.getListPieces().size() == level + 1;

            List<Cell> pieceMove = cache.get(piece.getName()).get(cell);
            boolean can = !board.getBusyCells().containsAll(pieceMove);
            if(can) {
                if(lastLevel) {
                    countCombinations++;
                    //cell = board.nextCell(cell);
                } else {
                    Board currentBoard = new Board(board);
                    level++;

                    currentBoard.getBusyCells().add(cell);
                    currentBoard.getCells().remove(cell);
                    currentBoard.getCells().removeAll(pieceMove);

                    process(currentBoard, currentBoard.getFreeCell(), currentBoard.getPiece(level), level);
                    level--;
                }
            }
            cell = board.nextCell(cell);
        }
    }

    public long calculateCombinations(int boardLength, List<String> listPieces) {
        ConfigBoard config = new ConfigBoard(boardLength, listPieces);
        Board board = new Board(config);
        long startTime = System.nanoTime();
        calculate(board);
        long endTime = System.nanoTime();
        System.out.println("calculate time: " + (endTime - startTime) / 1000000);
        System.out.println(countCombinations + " " + config.getRepetitiveCombinations());
        return countCombinations / config.getRepetitiveCombinations();
        //return countCombinations;
    }
}
