public class PieceFactory {
    public Piece getPiece(String pieceName) {
        Piece piece = new Piece() {
            @Override
            protected void calculateOccupiedCells(int x, int y, Board board) {

            }
        };
        switch (pieceName) {
            case ConfigBoard.QUEEN:
                piece = new Queen();
                break;
            case ConfigBoard.ROOK:
                piece = new Rook();
                break;
            case ConfigBoard.BISHOP:
                piece = new Bishop();
                break;
            case ConfigBoard.KING:
                piece = new King();
                break;
            case ConfigBoard.KNIGHT:
                piece = new Knight();
                break;
            case ConfigBoard.PAWN:
                piece = new Pawn();
                break;
        }
        return piece;
    }
}
