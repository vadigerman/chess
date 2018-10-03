public class PieceFactory {
    public Piece getPiece(String pieceName) {
        Piece piece = new Piece();
        switch (pieceName) {
            case "queen":
                piece = new Queen();
                break;
            case "rook":
                piece = new Rook();
                break;
            case "bishop":
                piece = new Bishop();
                break;
            case "king":
                piece = new King();
                break;
            case "knight":
                piece = new Knight();
                break;
            case "pawn":
                piece = new Pawn();
                break;
        }
        return piece;
    }
}
