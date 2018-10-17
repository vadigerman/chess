import java.util.ArrayList;
import java.util.List;

public class ConfigBoard {
    public static final String QUEEN = "queen";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String KING = "king";
    public static final String KNIGHT = "knight";
    public static final String PAWN = "pawn";

    private int sizeBoard;
    private List<Piece> listPieces = new ArrayList<>();

    public ConfigBoard(int sizeBoard, List<String> pieces) {
        this.sizeBoard = sizeBoard;
        calculateRepetitiveCombinations(pieces);
    }

    public void calculateRepetitiveCombinations(List<String> pieces) {
        for (String piece : pieces) {
            PieceFactory pieceFactory = new PieceFactory();
            listPieces.add(pieceFactory.getPiece(piece));
        }
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

    public int getSizeBoard() {
        return sizeBoard;
    }
}
