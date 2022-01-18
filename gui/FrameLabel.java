import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class FrameLabel {


    public static void main(String[] args) {

        //BILD
        ImageIcon tabPicture = new ImageIcon("C:\\Users\\akifn\\OneDrive - haw-hamburg.de\\Dokumente\\Bilder\\Emotes\\Sleep.png");
        ImageIcon ply1 = new ImageIcon("C:\\Users\\akifn\\OneDrive - haw-hamburg.de\\Dokumente\\Bilder\\icons\\icons8-student-64.png");
        Border brd = BorderFactory.createLineBorder(Color.CYAN);

        //Spieler1
        JLabel player1 = new JLabel(); //create a player1
        player1.setText("Tic Tac Toe"); //set Text of player1
        player1.setIcon(ply1); //Bild
        player1.setVerticalTextPosition(JLabel.TOP);      //rechts von Bild aber jetzt oben
        player1.setHorizontalTextPosition(JLabel.CENTER);     //oben über Bild mitte
        player1.setFont(new Font("MV Boli", Font.PLAIN, 10));   //set font of text //aussehen
        player1.setIconTextGap(0); //entfernung zwischen bild und text
        player1.setVerticalAlignment(JLabel.TOP); //bild oben links
        player1.setBorder(brd); //Border of Label
        //Label umfasst das ganze Hintergrund

        JFrame frame = new JFrame();  //frame GUI
        frame.setTitle("TicTacToe");  //Titel
        frame.setIconImage(tabPicture.getImage());
        frame.setVisible(true);     //visible
        frame.add(player1);   //player1 added
        //frame.add(player2);   //player2 added
        frame.setSize(500, 500);     //größe
        frame.getContentPane().setBackground(Color.gray);  //grau hintergrund

    }


    //        ImageIcon ply2 = new ImageIcon("C:\\Users\\akifn\\OneDrive - haw-hamburg.de\\Dokumente\\Bilder\\icons\\icons8-discord-logo-48.png");
//        //Spieler1
//        JLabel player1 = new JLabel(); //create a player1
//        player1.setText("Player.1"); //set Text of player1
//        player1.setIcon(ply1); //Bild
//        player1.setVerticalTextPosition(JLabel.TOP);      //rechts von Bild aber jetzt oben
//        player1.setHorizontalTextPosition(JLabel.CENTER);     //oben über Bild mitte
//        player1.setFont(new Font("MV Boli", Font.PLAIN,10));   //set font of text //aussehen
//        player1.setIconTextGap(0); //entfernung zwischen bild und text
//        player1.setVerticalAlignment(JLabel.TOP); //bild oben links
//        player1.setBorder(brd); //Border of Label
//        //Label umfasst das ganze Hintergrund
//
//        JLabel player2 = new JLabel();
//        player2.setText("Player.2"); //set Text of player1
//        player2.setIcon(ply2); //Bild
//        player2.setVerticalTextPosition(JLabel.TOP);      //rechts von Bild aber jetzt oben
//        player2.setHorizontalTextPosition(JLabel.CENTER);     //oben über Bild mitte
//        player2.setFont(new Font("MV Boli", Font.PLAIN,10));   //set font of text //aussehen
//        player2.setIconTextGap(0); //entfernung zwischen bild und text
//        //player1.setVerticalAlignment(JLabel.RIGHT); //bild oben links

}
