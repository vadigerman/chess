import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FSM {
    ResourceBundle myBundle = ResourceBundle.getBundle("Labels");
    private Scanner scanner = new Scanner(System.in);

    private Set<String> createSetPieces() {
        Set<String> pieces = new TreeSet<String>();
        pieces.add(ConfigBoard.QUEEN);
        pieces.add(ConfigBoard.ROOK);
        pieces.add(ConfigBoard.BISHOP);
        pieces.add(ConfigBoard.KING);
        pieces.add(ConfigBoard.KNIGHT);
        pieces.add(ConfigBoard.PAWN);
        return pieces;
    }

    public int getBoardSize() {
        int boardSize = question0();
        while (boardSize <= 0) {
            boardSize = question0();
        }
        return boardSize;
    }

    public List<String> getConfigPieces() {
        List<String> listPieces = new ArrayList<String>();
        String finalAnswer = myBundle.getString("final_answer");
        Set<String> pieces = createSetPieces();
        while (finalAnswer.equals(myBundle.getString("final_answer"))) {
            String piece = question1();
            while (!pieces.contains(piece)) {
                piece = question1();
            }
            int count = question2();
            while (count <= 0) {
                count = question2();
            }
            for (int i = 0; i < count; i++) {
                listPieces.add(piece);
            }
            finalAnswer = question3();
        }
        return listPieces;
    }

    private int question0() {
        System.out.println(myBundle.getString("chessboard_size"));
        return scanner.nextInt();
    }

    private String question1() {
        System.out.println(myBundle.getString("piece_name"));
        return scanner.next().toLowerCase();
    }

    private int question2() {
        System.out.println(myBundle.getString("how_many"));
        return scanner.nextInt();
    }

    private String question3() {
        System.out.println(myBundle.getString("any_piece"));
        return scanner.next().toLowerCase();
    }
}

