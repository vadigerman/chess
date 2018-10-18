import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class FSM {
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

    public List<String> question() {
        List<String> listPieces = new ArrayList<String>();
        String finalAnswer = "yes";
        Set<String> pieces = createSetPieces();
        while (finalAnswer.equals("yes")) {
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

    private String question1() {
        System.out.println("Enter piece name (queen, rook, bishop, king, knight, pawn)");
        return scanner.next().toLowerCase();
    }

    private int question2() {
        System.out.println("How many? (must be a positive number)");
        return scanner.nextInt();
    }

    private String question3() {
        System.out.println("Enter any piece? (yes/no)");
        return scanner.next().toLowerCase();
    }
}

