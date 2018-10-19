public class PieceFactory {
    public Piece getPiece(String pieceName) {
        Piece piece = new Piece();
        switch (pieceName) {
            case ConfigBoard.QUEEN:
                piece = new CompoundQueen(new Rook(), new Bishop());
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
