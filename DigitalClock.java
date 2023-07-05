import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;


public class DigitalClock extends JFrame implements ActionListener{
    JLabel topLabel;
    JLabel timeLabel, dateLabel;


    DigitalClock() {
        super("Digital Clock");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        topLabel = new JLabel();
        topLabel.setSize(500, 25);
        // topLabel.setLocation(0, 0);
        // add(topLabel);

        // ImageIcon ig = new ImageIcon("Back.jpg");
        // Image scaledImage = ig.getImage().getScaledInstance(20, 15, Image.SCALE_SMOOTH);
        // ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // topLabel.setIcon(scaledIcon);


        topLabel.setBounds(100, 100, 200, 200);
        topLabel.setBackground(Color.BLACK);
        add(topLabel);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String [] argc) {
        SwingUtilities.invokeLater(() -> new DigitalClock());
    }
}
