import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Test extends JFrame implements ActionListener{
    JButton button1, button2, button3;
    JLabel demo, text, demoButton;
    int count = 0;
    Test(){
        setTitle("Welcome");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.CYAN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        demo = new JLabel();
        demo.setSize(500, 30);
        demo.setLocation(0, 0);
        demo.setOpaque(true);
        demo.setBackground(Color.RED);
        add(demo);
        
        // ImageIcon ig = new ImageIcon("Back.jpg");
        // Image scaledImage = ig.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        // ImageIcon scaledIcon = new ImageIcon(scaledImage);

        demoButton = new JLabel("Welcome");
        demoButton.setSize(100, 25);
        demoButton.setLocation(220, 2);
        demo.add(demoButton);




        button1 = new JButton("Text Editor", null);
        button1.setSize(120, 50);
        button1.setLocation(190, 100);
        add(button1);

        button2 = new JButton("Unit Converter", null);
        button2.setSize(120, 50);
        button2.setLocation(190, 160);
        add(button2);

        button3 = new JButton("Digital Clock", null);
        button3.setSize(120, 50);
        button3.setLocation(190, 220);
        add(button3);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
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
        SwingUtilities.invokeLater(() -> new Test());
    }
}
