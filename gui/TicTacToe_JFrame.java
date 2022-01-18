import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TicTacToe_JFrame {

    public static void main(String[] args) {
        TicTacToe_JFrame test = new TicTacToe_JFrame();
        test.frame.getContentPane();
    }

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel playField = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];  //Spielfeld Clickable fields
    ImageIcon ply1 = new ImageIcon("C:\\Users\\akifn\\OneDrive - haw-hamburg.de\\Dokumente\\Bilder\\icons\\icons8-student-64.png");
    ImageIcon image = new ImageIcon("C:\\Users\\akifn\\OneDrive - haw-hamburg.de\\Dokumente\\Bilder\\Emotes\\Sleep.png");


    TicTacToe_JFrame() {

        frame.setTitle("Tic-Tac-Toe  Akif Aydin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(Color.black);
        textfield.setForeground(Color.orange); //green also nice
        textfield.setFont(new Font("MV Boli", Font.PLAIN, 50));   //set font of text //aussehen
        textfield.setIcon(ply1);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        playField.setLayout(new GridLayout(3,3));
        //playField.setBackground(Color.yellow);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            playField.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD,120));
            buttons[i].setFocusable(false);
            //buttons[i].addActionListener(new ActionListener());

        }

        title_panel.setLayout(new BorderLayout());
        //title_panel.setBounds(0,0,800,100);
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(playField); //BorderLayout.WEST
        frame.setIconImage(image.getImage());


    }

}
