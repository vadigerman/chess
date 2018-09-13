public class Piece {
    protected int indexX;
    protected int indexY;
    private int boardSize;
    protected Square[][] occupiedSquare;

    public int getIndexX() {
        return indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Square[][] getOccupiedSquare() {
        return occupiedSquare;
    }
}
