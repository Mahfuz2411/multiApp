import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.TimeZone;
import javax.swing.Timer;



public class DigitalClock extends JFrame implements ActionListener{
    private JLabel topLabel, lowLabel;
    private JLabel timeLabel, dateLabel;
    private JComboBox<String> timeZoneComboBox;
    private JButton formatButton;
    private boolean is24HourFormat=true, firstTime=true;


    DigitalClock() {
        super("Digital Clock");
        getContentPane().setBackground(Color.GRAY);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a file menu (Image)
        ImageIcon ig = new ImageIcon("Images/menu-burger.png");
        Image scaledImage = ig.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //!Frame Icon (Image)
        Image scaledImage2 = Toolkit.getDefaultToolkit().getImage("Images/clock.png");
        setIconImage(scaledImage2);
        
        JMenu fileMenu = new JMenu();
        fileMenu.setIcon(scaledIcon);

        // Create file menu items
        JMenuItem homeMenuItem = new JMenuItem("Home");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        // Add action listeners to menu items
        homeMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        // Add file menu items to file menu
        fileMenu.add(homeMenuItem);
        fileMenu.add(exitMenuItem);

        // Add file menu to menu bar
        menuBar.add(fileMenu);

        // Set menu bar for the frame
        setJMenuBar(menuBar);

        topLabel = new JLabel();
        topLabel.setOpaque(true);
        topLabel.setBackground(Color.DARK_GRAY);
        topLabel.setBounds(50, 100, 400, 200);
        topLabel.setText("Demo Text");
        add(topLabel);
        
        lowLabel = new JLabel();
        lowLabel.setOpaque(true);
        lowLabel.setBackground(Color.GRAY);
        lowLabel.setBounds(5, 5, 390, 190);
        topLabel.add(lowLabel);

        timeLabel = new JLabel("", JLabel.CENTER);
        timeLabel.setFont(new Font("Poppins", Font.BOLD, 40));
        timeLabel.setOpaque(true);
        timeLabel.setBackground(Color.DARK_GRAY);
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setBounds(5, 5, 380, 80);
        lowLabel.add(timeLabel);

        dateLabel = new JLabel("", JLabel.CENTER);
        dateLabel.setFont(new Font("Courier New", Font.BOLD, 40));
        dateLabel.setOpaque(true);
        dateLabel.setBackground(Color.DARK_GRAY);
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setBounds(5, 100, 380, 80);
        lowLabel.add(dateLabel);

        timeZoneComboBox = new JComboBox<>(TimeZone.getAvailableIDs());
        timeZoneComboBox.setPreferredSize(new Dimension(200, 30));
        timeZoneComboBox.setSize(400, 30);
        timeZoneComboBox.setLocation(50, 320);
        add(timeZoneComboBox);

        timeZoneComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTimeZone = (String) timeZoneComboBox.getSelectedItem();
                updateTime(selectedTimeZone);
            }
        });

        //!--------------------------------Need to Change-------------------------------------------

        formatButton = new JButton("24");
        formatButton.setBounds(325, 0, 50, 25);
        formatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                is24HourFormat = !is24HourFormat;
                if(is24HourFormat) formatButton.setText("24");
                else formatButton.setText("12");
                updateTime((String) timeZoneComboBox.getSelectedItem());
            }
        });
        timeLabel.add(formatButton);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime((String) timeZoneComboBox.getSelectedItem());
            }
        });
        timer.start();

        
        setVisible(true);
    }

    private void updateTime(String timeZone) {
        if(firstTime) {
            timeZone = "Asia/Dhaka";
            timeZoneComboBox.setSelectedItem(timeZone);
            firstTime = !firstTime;
        } //Etc/GMT+6
        SimpleDateFormat timeFormat;
        if(is24HourFormat) timeFormat = new SimpleDateFormat("HH:mm:ss");
        else timeFormat = new SimpleDateFormat("hh:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");//yyyy-MM-dd
        timeFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        
        Date date = new Date();
        timeLabel.setText(timeFormat.format(date));
        dateLabel.setText(dateFormat.format(date));
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Home")) {
            dispose();
            SwingUtilities.invokeLater(() -> new Home());
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
    }

    public static void main(String [] argc) {
        SwingUtilities.invokeLater(() -> new DigitalClock());
    }
}
