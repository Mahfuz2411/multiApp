import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Home extends JFrame implements ActionListener{
    JButton button1, button2, button3;
    JLabel demo, text, demoButton;
    int count = 0;
    Home(){
        setTitle("Welcome");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        demo = new JLabel("WELCOME", JLabel.CENTER);
        demo.setSize(500, 30);
        demo.setLocation(0, 0);
        demo.setOpaque(true);
        demo.setBackground(Color.DARK_GRAY);
        demo.setForeground(Color.WHITE);
        demo.setFont(new Font("Courier New", Font.BOLD, 25));
        add(demo);
        
        //!Frame Icon (Image)
        Image scaledImage2 = Toolkit.getDefaultToolkit().getImage("Images/home.png");
        setIconImage(scaledImage2);

        setIconImage(scaledImage2);



        button1 = new JButton("Text Editor");
        button1.setOpaque(true);
        button1.setBackground(Color.DARK_GRAY);
        button1.setForeground(Color.WHITE);
        button1.setSize(300, 60);
        button1.setLocation(100, 100);
        button1.setFont(new Font("Poppins", Font.BOLD, 20));
        add(button1);

        button2 = new JButton("Unit Converter");
        button2.setOpaque(true);
        button2.setBackground(Color.DARK_GRAY);
        button2.setForeground(Color.WHITE);
        button2.setSize(300, 60);
        button2.setLocation(100, 170);
        button2.setFont(new Font("Poppins", Font.BOLD, 20));
        add(button2);

        button3 = new JButton("Digital Clock");
        button3.setOpaque(true);
        button3.setBackground(Color.DARK_GRAY);
        button3.setForeground(Color.WHITE);
        button3.setSize(300, 60);
        button3.setLocation(100, 240);
        button3.setFont(new Font("Poppins", Font.BOLD, 20));
        add(button3);

        button1.addActionListener(this);  //text
        button2.addActionListener(this);  //Unit
        button3.addActionListener(this);  //clock
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try {
            if(cmd.equals("Text Editor")){
                setVisible(false);
                // SwingUtilities.invokeLater(() -> new TextEditor());
                TextEditor ob = new TextEditor();
            } else if (cmd.equals("Unit Converter")) {
                setVisible(false);
                UnitConverter ob = new UnitConverter();
            } else if (cmd.equals("Digital Clock")) {
                setVisible(false);
                DigitalClock ob = new DigitalClock();
            }
        } catch (Exception ext) {
            String errorMssg = ext.getMessage();
            JOptionPane.showMessageDialog(null, errorMssg, "Error", 2);
        }
    }

    public static void main(String [] argc) {
        SwingUtilities.invokeLater(() -> new Home());
    }
}
