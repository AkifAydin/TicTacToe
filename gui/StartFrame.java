import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {

    public JFrame frame = new JFrame();
    public JLabel textfield = new JLabel();
    public JLabel textfield2 = new JLabel();
    public JPanel title_panel = new JPanel();
    ImageIcon image = new ImageIcon("gui/icon/Sleep.png");
    ImageIcon ply1 = new ImageIcon("gui/icon/icons8-student-64.png");

    public StartFrame(){
        frame.setTitle("Tic-Tac-Toe  Akif Aydin");
        frame.setIconImage(image.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

        //Textfield upper part
        textfield.setBackground(Color.black);
        textfield.setForeground(Color.orange); //green also nice
        textfield.setFont(new Font("MV Boli", Font.PLAIN, 50));   //set font of text //aussehen
        textfield.setIcon(ply1);
        textfield.setHorizontalAlignment(SwingConstants.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        //Textfield upper part
        textfield2.setBackground(Color.black);
        textfield2.setForeground(Color.orange); //green also nice
        textfield2.setFont(new Font("MV Boli", Font.PLAIN, 50));   //set font of text //aussehen
        textfield2.setIcon(ply1);
        textfield2.setHorizontalAlignment(SwingConstants.CENTER);
        textfield2.setText("Tic-Tac-Toe");
        textfield2.setOpaque(true);

        title_panel.setLayout(new BorderLayout()); //Titel bereich oben
        title_panel.add(textfield);   //titel inhalt
        title_panel.add(textfield2);   //titel inhalt
        title_panel.setBounds(0, 0, 800, 100);  //Titel Position
        frame.add(title_panel, BorderLayout.NORTH);  //ins frame rein

    }



    public void textChange(){
        title_panel.removeAll();
        title_panel.add(textfield);   //titel inhalt
    }

}