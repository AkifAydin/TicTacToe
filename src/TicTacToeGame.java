import java.util.*;

/**
 * Represents a simple TicTacToe Game.
 *
 * @author Akif Aydin
 */

public class TicTacToeGame {

    private static final int SIZE = 3;  //spielfeld größe
    private static final Map<Integer, String> spieler = new HashMap<>();  //spieler
    private static final String[][] field = new String[SIZE][SIZE];   //empty field

    public static void startPlayground(String[][] pg) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pg[i][j] = "-";
            }
        }
    }

    public static void players() {
        String player1 = "x";
        String player2 = "o";
        spieler.put(0, player1);
        spieler.put(1, player2);
    }

    public static boolean isValidField(int x, int y, String[][] pg) {
        return pg[x][y].equals("-");
    }

    public static void playersTurn(int x, int y, String player, String[][] pg) {
        //Prüfen ob feld schon belegt ist?
        while (!(isValidField(x, y, pg))) {
            System.out.println("Bitte ein Leeres Feld angeben: ");
            x = eingabe();
            y = eingabe();
        }
        //leeres feld belegen
        pg[x][y] = player;
        //feld ausgeben
        for (String[] elem : pg) {
            System.out.println(Arrays.toString(elem));
        }
    }

    public static boolean isWinner(String[][] pg, String player) {
        //[x, x, x]
        //[-, -, -]
        //[-, -, -]
        if (pg[0][0].equals(player) && pg[0][1].equals(player) && pg[0][2].equals(player)) return true;
        //[-, -, -]
        //[x, x, x]
        //[-, -, -]
        if (pg[1][0].equals(player) && pg[1][1].equals(player) && pg[1][2].equals(player)) return true;
        //[-, -, -]
        //[-, -, -]
        //[x, x, x]
        if (pg[2][0].equals(player) && pg[2][1].equals(player) && pg[2][2].equals(player)) return true;
        //[x, -, -]
        //[-, x, -]
        //[-, -, x]
        if (pg[0][0].equals(player) && pg[1][1].equals(player) && pg[2][2].equals(player)) return true;
        //[-, -, x]
        //[-, x, -]
        //[x, -, -]
        if (pg[2][0].equals(player) && pg[1][1].equals(player) && pg[0][2].equals(player)) return true;
        //[x, -, -]
        //[x, -, -]
        //[x, -, -]
        if (pg[0][0].equals(player) && pg[1][0].equals(player) && pg[2][0].equals(player)) return true;
        //[-, -, x]
        //[-, -, x]
        //[-, -, x]
        if (pg[0][2].equals(player) && pg[1][2].equals(player) && pg[2][2].equals(player)) return true;

        return false;
    }

    public static boolean allFieldsUsed(String[][] pg) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (pg[i][j].equals("-")) {
                    return false;
                }
            }
        }
        System.out.println("Sadly No Winner this Time!");
        return true;
    }

    public static int eingabe() {
        int x;
        Scanner scn = new Scanner(System.in);
        x = scn.nextInt();
        while (x<0 || x>2) {
            System.out.println("Eingabe nicht im bereich des Spielfelds");
            System.out.println("bitte 0, 1 oder 2 eingeben");
            x = scn.nextInt();
        }
        return x;
    }

    //random 0 or 1 Player start
    public static void main(String[] args) {
        //Koordinaten
        int x;
        int y;

        //wer beginnt?
        Random rnd = new Random();
        int whoStarts = rnd.nextInt(2);

        startPlayground(field); //init StartPlayfield
        System.out.println("Welcome To Tic-Tac-Toe");
        for (String[] elem : field) {
            System.out.println(Arrays.toString(elem));
        }

        players(); //init players

        //so lange spielen wie noch felder frei sind
        while (!allFieldsUsed(field)) {

            //Spieler am Zug
            if (spieler.get(whoStarts).equals("x")) {
                System.out.println("Your Turn Player1");
            } else {
                System.out.println("Your Turn Player2");
            }

            //feld angabe
            x = eingabe();
            y = eingabe();

            //spielzug
            playersTurn(x, y, spieler.get(whoStarts), field);

            //winner?
            if (isWinner(field, spieler.get(whoStarts))) {
                System.out.println("You are the Winner!");
                break;
            }

            if (whoStarts == 1) {
                whoStarts = 0;
            } else whoStarts++;
        }

    }


}
