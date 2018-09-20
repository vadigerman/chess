import java.util.List;
import java.util.Stack;

public class ConfigBoard {
    int sizeBoard;
    List<String> listPieces;
    Stack<String> stackPieces = new Stack<String>();

    public ConfigBoard(int sizeBoard, List<String> listPieces) {
        this.sizeBoard = sizeBoard;
        this.listPieces = listPieces;
    }

    public int getSizeBoard() {
        return sizeBoard;
    }

    public void setSizeBoard(int sizeBoard) {
        this.sizeBoard = sizeBoard;
    }

    public String getNameNextPiece() {
        return listPieces.get(0);
    }

    public void updateListPieces() {
        stackPieces.push(listPieces.get(0));
        listPieces.remove(0);
    }

    public List<String> getListPieces() {
        return listPieces;
    }

    public void setListPieces(List<String> listPieces) {
        this.listPieces = listPieces;
    }

    public Piece getPiece() {
        String pieceName = getNameNextPiece();
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
