import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConfigBoard {
    int sizeBoard;
    List<Piece> listPieces = new ArrayList<Piece>();
    Stack<Piece> stackPieces = new Stack<Piece>();

    public ConfigBoard(int sizeBoard, List<String> pieces) {
        this.sizeBoard = sizeBoard;
        for (String piece : pieces) {
            listPieces.add(convertStringToPiece(piece));
        }
    }

    public List<Piece> getListPieces() {
        return listPieces;
    }

    public void setListPieces(List<Piece> listPieces) {
        this.listPieces = listPieces;
    }

    public Stack<Piece> getStackPieces() {
        return stackPieces;
    }

    public void setStackPieces(Stack<Piece> stackPieces) {
        this.stackPieces = stackPieces;
    }

    public int getSizeBoard() {
        return sizeBoard;
    }

    public void setSizeBoard(int sizeBoard) {
        this.sizeBoard = sizeBoard;
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
        if (pieceName.equals("king")) {
            piece = new King();
        } else if (pieceName.equals("knight")) {
            piece = new Knight();
        } else if (pieceName.equals("pawn")) {
            piece = new Pawn();
        } else if (pieceName.equals("rook")) {
            piece = new Rook();
        } else if (pieceName.equals("bishop")) {
            piece = new Bishop();
        } else if (pieceName.equals("queen")) {
            piece = new Queen();
        }
        return piece;
    }
}
