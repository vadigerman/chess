import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConfigBoard {
    int sizeBoard;
    List<Piece> listPieces = new ArrayList<>();
    Stack<Piece> stackPieces = new Stack<>();
    int repetitiveCombinations = 1;

    public ConfigBoard(int sizeBoard, List<String> pieces) {
        this.sizeBoard = sizeBoard;
        String currentPiece = "";
        int multiplier = 1;
        for (String piece : pieces) {
            listPieces.add(convertStringToPiece(piece));
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

    public void pushPiece() {
        stackPieces.push(listPieces.get(0));
        listPieces.remove(0);
    }

    public void popPiece() {
        listPieces.add(0, stackPieces.pop());
        listPieces.get(1).setClosedCells(null);
    }

    public Piece getPiece() {
        return listPieces.get(0);
    }

    public Piece convertStringToPiece(String pieceName) {
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
