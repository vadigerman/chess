public class Knight extends Piece {
    public Knight() {
        indexX = 2;
        indexY = 2;
        int n = 5;
        occupiedSquare = new Square[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if ((Math.abs(indexX - i) + Math.abs(indexY - j)) == 3 || (i == indexX && j == indexY)) {
                    occupiedSquare[i][j] = new Square(SquareState.ATTACKED);
                } else {
                    occupiedSquare[i][j] = new Square(SquareState.EMPTY);
                }
            }
        }
    }
}
