import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;

public class TicTacToe_JFrame {  // implements ActionListener {

    private static final int SIZE = 9;  //spielfeld größe
    private static final Map<Integer, String> spieler = new HashMap<>();  //spieler
    private static Boolean WINNERFOUND = false;
    //private static ActionEvent click;

    public static void main(String[] args) {
        TicTacToe_JFrame ttt = new TicTacToe_JFrame();
    }

    //wer beginnt?
    Random rnd = new Random();
    int whoStarts = rnd.nextInt(2);  //zum Entscheiden, wer am Zug ist (random)
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel playField = new JPanel();
    JLabel textfield = new JLabel();
    Border brd = BorderFactory.createLineBorder(Color.ORANGE, 5);
    JButton[] buttons = new JButton[9];  //Spielfeld Clickable fields
    ImageIcon ply1 = new ImageIcon("gui/icon/icons8-student-64.png");
    ImageIcon image = new ImageIcon("gui/icon/Sleep.png");


    TicTacToe_JFrame() {

        frame.setTitle("Tic-Tac-Toe  Akif Aydin");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        textfield.setBackground(Color.black);
        textfield.setForeground(Color.orange); //green also nice
        textfield.setFont(new Font("MV Boli", Font.PLAIN, 50));   //set font of text //aussehen
        textfield.setIcon(ply1);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        playField.setLayout(new GridLayout(3, 3));
        playField.setBounds(200, 200, 400, 400);
        playField.setBorder(brd);


        for (int i = 0; i < buttons.length; i++) {  //alle buttons in den Spielfeld ADDEN
            buttons[i] = new JButton();
            playField.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 40));
            buttons[i].setFocusable(false);  //default is true
            //buttons[i].addActionListener(new ActionListener());
        }

        title_panel.setLayout(new BorderLayout()); //Titel bereich oben
        title_panel.add(textfield);   //titel inhalt
        title_panel.setBounds(0, 0, 800, 100);  //Titel Position
        frame.add(title_panel, BorderLayout.NORTH);  //ins frame rein
        frame.add(playField);

        startGame();
    }


    public void startGame() {

        //init StartPlayfield
        startPlayground(buttons);

        //init players
        players();


        //so lange spielen wie noch felder frei sind
        while (!allFieldsUsed(buttons)) {
            //Spieler am Zug
            if (spieler.get(whoStarts).equals("x")) {
                textfield.setText("Your Turn Player1");
            } else {
                textfield.setText("Your Turn Player2");
            }

            if (WINNERFOUND) {
                if (spieler.get(whoStarts).equals("x")) {
                    textfield.setText("Player1 is the Winner");
                } else {
                    textfield.setText("You are the Winner Player2");
                }
                break;
            } else {
                for (int i = 0; i < SIZE; i++) {   //Zug vom Spieler (Klick auf beliebiges Feld erkennen)
                if (buttons[i].getModel().isPressed() && isValidField(buttons[i])) {
                        //Feld mit symbol des Spielers befüllen wenn Valid
                        eingabe(buttons[i], spieler.get(whoStarts));
                        //Spieler wechseln
                        if (whoStarts == 1) {
                            if (isWinner(playField, spieler.get(whoStarts))) {
                                WINNERFOUND = true;
                            } else whoStarts = 0;
                        } else if (isWinner(playField, spieler.get(whoStarts))) {
                            WINNERFOUND = true;
                        } else whoStarts++;
                        break;
                    }
                }

            }
        }
    }

    public void startPlayground(JButton[] field) {
        for (int i = 0; i < SIZE; i++) {
            field[i].setText("-");
        }
    }

    public void players() {
        String player1 = "x";
        String player2 = "o";
        spieler.put(0, player1);
        spieler.put(1, player2);
    }

    public static boolean isValidField(JButton field) {
        return field.getText().equals("-");
    }

    public boolean isWinner(JPanel pg, String player) {
        //[x, x, x]
        //[-, -, -]
        //[-, -, -]
        if ((buttons[0].getText().equals(player)) && buttons[1].getText().equals(player) && (buttons[2].getText().equals(player)))
            return true;
        //[-, -, -]
        //[x, x, x]
        //[-, -, -]
        if ((buttons[3].getText().equals(player)) && buttons[4].getText().equals(player) && (buttons[5].getText().equals(player)))
            return true;
        //[-, -, -]
        //[-, -, -]
        //[x, x, x]
        if ((buttons[6].getText().equals(player)) && buttons[7].getText().equals(player) && (buttons[8].getText().equals(player)))
            return true;
        //[x, -, -]
        //[-, x, -]
        //[-, -, x]
        if ((buttons[0].getText().equals(player)) && buttons[3].getText().equals(player) && (buttons[6].getText().equals(player)))
            return true;
        //[-, -, x]
        //[-, x, -]
        //[x, -, -]
        if ((buttons[2].getText().equals(player)) && buttons[4].getText().equals(player) && (buttons[6].getText().equals(player)))
            return true;
        //[x, -, -]
        //[x, -, -]
        //[x, -, -]
        if ((buttons[2].getText().equals(player)) && buttons[5].getText().equals(player) && (buttons[8].getText().equals(player)))
            return true;
        //[-, -, x]
        //[-, -, x]
        //[-, -, x]
        if ((buttons[0].getText().equals(player)) && buttons[4].getText().equals(player) && (buttons[8].getText().equals(player)))
            return true;
        //[-, -, x]
        //[-, x, -]
        //[x, -, -]
        if ((buttons[1].getText().equals(player)) && buttons[4].getText().equals(player) && (buttons[7].getText().equals(player)))
            return true;
        return false;
    }

    public boolean allFieldsUsed(JButton[] butns) {
        for (int i = 0; i < 9; i++) {
            if (butns[i].getText().equals("-")) {
                return false;  //wenn nicht alle Felder belegt sind
            }
        }
        if (isWinner(playField, spieler.get(whoStarts))) {
            if (spieler.get(whoStarts).equals("x")) {
                textfield.setText("Player1 is the Winner");
            } else {
                textfield.setText("You are the Winner Player2");
            }
        }else  textfield.setText("Sadly No Winner this Time!");
        return true; //wenn alle Felder belegt sind
    }

    public void eingabe(JButton feld, String player) {
        feld.setForeground(Color.BLACK);  //Farbe von X und O
        feld.setText(player);  //Spieler
    }

}
