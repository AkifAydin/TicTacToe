import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {
        //JFrame frame = new JFrame();  //Frame
        this.setTitle("TicTacToe");  //Titel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
        this.setResizable(false);  //prevent frame from being resized
        this.setSize(400, 400);  //größe
        this.setVisible(true);  //visible Frame

        ImageIcon image = new ImageIcon("C:\\Users\\akifn\\OneDrive - haw-hamburg.de\\Dokumente\\Bilder\\Emotes\\Sleep.png");
        this.setIconImage(image.getImage());
        //frame.getContentPane().setBackground(Color.gray);
        this.getContentPane().setBackground(new Color(57, 201, 106));
    }
}
