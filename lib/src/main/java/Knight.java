import java.util.List;

public class Knight extends Piece {
    public Knight() {
        setName(ConfigBoard.KNIGHT);
//        setOnBoard(false);
    }

    @Override
    protected void calculateOccupiedCells(int x, int y, Board board) {
        clearOccupiedCells();
        Cell cell = new Cell(-1, -1);
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i - j) == (x - y)) || ((i + j) == (x + y))) {
                    if (!(i == x && j == y)) {
                        addOccupiedCells(cell, i, j, board);
                    }
                }
            }
        }
    }

//    public boolean isOccupiedCells(int x, int y, Board board) {
//        int n = board.getSize();
//        Cell cell = new Cell(-1, -1);
//        getOccupiedCells().clear();
//        for(int i = x - 2; i <= x + 2; i++) {
//            for (int j = y - 2; j <= y + 2; j++) {
//                if (i >= 0 && j >= 0 && i < n && j < n) {
//                    if ((Math.abs(x - i) + Math.abs(y - j)) == 3) {
//                        cell.setX(i);
//                        cell.setY(j);
//                        if (!checkCell(board, cell)) {
//                            return false;
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
