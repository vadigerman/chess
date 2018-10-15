import java.util.ArrayList;
import java.util.List;

public class ConfigBoard {
    public static final String QUEEN = "queen";
    public static final String ROOK = "rook";
    public static final String BISHOP = "bishop";
    public static final String KING = "king";
    public static final String KNIGHT = "knight";
    public static final String PAWN = "pawn";

    int sizeBoard;
    List<Piece> listPieces = new ArrayList<>();
    int repetitiveCombinations = 1;

    public ConfigBoard(int sizeBoard, List<String> pieces) {
        this.sizeBoard = sizeBoard;
        calculateRepetitiveCombinations(pieces);
    }

    public void calculateRepetitiveCombinations(List<String> pieces) {
        int multiplier = 1;
        String currentPiece = "";
        for (String piece : pieces) {
            PieceFactory pieceFactory = new PieceFactory();
            listPieces.add(pieceFactory.getPiece(piece));
            if (currentPiece.equals(piece)) {
                repetitiveCombinations = repetitiveCombinations * multiplier;
                multiplier++;
            } else {
                multiplier = 2;
            }
            currentPiece = piece;
        }
    }

    public int getRepetitiveCombinations() {
        return repetitiveCombinations;
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

    public int getSizeBoard() {
        return sizeBoard;
    }
}
