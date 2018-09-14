public class Bishop extends Piece {
    public Bishop(int n, Square square) {
        indexX = square.getX();
        indexY = square.getY();
        occupiedSquare = new Square[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (((i - j) == (indexX - indexY)) || ((i + j) == (indexX + indexY))) {
                    occupiedSquare[i][j] = new Square(SquareState.ATTACKED);
                } else {
                    occupiedSquare[i][j] = new Square(SquareState.EMPTY);
                }
            }
        }
    }
}
