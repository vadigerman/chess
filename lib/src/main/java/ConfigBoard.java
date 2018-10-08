import java.util.ArrayList;
import java.util.List;

public class ConfigBoard {
    int sizeBoard;
    List<Piece> listPieces = new ArrayList<>();
    long repetitiveCombinations = 1;

    public ConfigBoard(int sizeBoard, List<String> pieces) {
        this.sizeBoard = sizeBoard;
        calculateRepetitiveCombinations(pieces);
    }

    public void calculateRepetitiveCombinations(List<String> pieces) {
        long multiplier = 1;
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

    public long getRepetitiveCombinations() {
        return repetitiveCombinations;
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

    public int getSizeBoard() {
        return sizeBoard;
    }
}
