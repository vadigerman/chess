public class Pawn extends Piece {
    public Pawn() {
        indexX = 1;
        indexY = 0;
        int n = 3;
        int m = 2;
        occupiedSquare = new Square[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                occupiedSquare[i][j] = new Square(true);
            }
        }
        occupiedSquare[indexX][indexY].setState(false);
        occupiedSquare[indexX - 1][indexY + 1].setState(false);
        occupiedSquare[indexX + 1][indexY + 1].setState(false);
    }
}
