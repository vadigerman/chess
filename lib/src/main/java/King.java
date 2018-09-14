public class King extends Piece {
    public King(Square square) {
        indexX = 1;
        indexY = 1;
        int n = 3;
        occupiedSquare = new Square[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                occupiedSquare[i][j] = new Square(SquareState.ATTACKED);
            }
        }
    }
}
