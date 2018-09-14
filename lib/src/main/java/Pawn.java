public class Pawn extends Piece {
    public Pawn() {
        indexX = 1;
        indexY = 0;
        int n = 3;
        int m = 2;
        occupiedSquare = new Square[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                occupiedSquare[i][j] = new Square(SquareState.EMPTY);
            }
        }
        occupiedSquare[indexX - 1][indexY + 1].setState(SquareState.ATTACKED);
        occupiedSquare[indexX + 1][indexY + 1].setState(SquareState.ATTACKED);
    }
}
