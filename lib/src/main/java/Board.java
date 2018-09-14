public class Board {
    private Square[][] squares;
    private int size;

    public Board(int size) {
        this.size = size;
        squares = new Square[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                squares[i][j] = new Square(SquareState.EMPTY);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }
}


