import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnitConverter extends JFrame implements ActionListener{
    JTextField fromField;
    JLabel fromLabel, toLabel;
    JLabel toField;
    JComboBox fromCombo, toCombo;
    JButton button;
    double value;
    private final String[] units = {"Atomic Mass Unit", "Carat", "Kilogram", "Ounce", "Pound", "Metric Ton", "Milligram", "Gram"};

    UnitConverter(){
        super("Unit Converter");
        getContentPane().setBackground(Color.GRAY);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Create a menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create a file menu (Image)
        ImageIcon ig = new ImageIcon("Images/menu-burger.png");
        Image scaledImage = ig.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //!Frame Icon (Image)
        Image scaledImage2 = Toolkit.getDefaultToolkit().getImage("Images/exchange.png");
        setIconImage(scaledImage2);
         
        JMenu fileMenu = new JMenu();
        fileMenu.setIcon(scaledIcon);

        // Create file menu items
        JMenuItem homeMenuItem = new JMenuItem("Home");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
 
        // Add action listeners to menu items
        homeMenuItem.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            SwingUtilities.invokeLater(() -> new Home());
        }
        });
        exitMenuItem.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        });

        // Add file menu items to file menu
        fileMenu.add(homeMenuItem);
        fileMenu.add(exitMenuItem);

        // Add file menu to menu bar
        menuBar.add(fileMenu);

        // Set menu bar for the frame
        setJMenuBar(menuBar);
        
        

        fromLabel = new JLabel("From: ", JLabel.CENTER);
        fromLabel.setOpaque(true);
        fromLabel.setBackground(Color.WHITE);
        fromLabel.setSize(150, 25);
        fromLabel.setLocation(80, 80);
        add(fromLabel);

        toLabel = new JLabel("To: ", JLabel.CENTER);
        toLabel.setOpaque(true);
        toLabel.setBackground(Color.WHITE);
        toLabel.setSize(150, 25);
        toLabel.setLocation(300, 80);
        add(toLabel);

        fromField = new JTextField(10);
        fromField.setSize(150, 25);
        fromField.setLocation(80, 110);
        add(fromField);

        toField = new JLabel("Result: ");
        toField.setOpaque(true);
        toField.setBackground(Color.WHITE);
        toField.setSize(150, 25);
        toField.setLocation(300, 110);
        add(toField);

        fromCombo = new JComboBox<>(units);
        fromCombo.setSize(150, 25);
        fromCombo.setLocation(80, 140);
        add(fromCombo);

        toCombo = new JComboBox<>(units);
        toCombo.setSize(150, 25);
        toCombo.setLocation(300, 140);
        add(toCombo);

        button = new JButton("Convert");
        button.setSize(370, 25);
        button.setLocation(80, 170);
        button.setHorizontalAlignment(JButton.CENTER);
        add(button);

        button.addActionListener(this);

        setVisible(true);
    }
    

    public void actionPerformed(ActionEvent e) {
        convert();
    }

    private void convert() {
        String fromUnit = (String) fromCombo.getSelectedItem();
        String toUnit = (String) toCombo.getSelectedItem();
        try {
            value = Double.parseDouble(fromField.getText());
        } catch(Exception e) {
            JOptionPane.showMessageDialog(super.getContentPane(), "Something went wrong", "Warnig Message", JOptionPane.WARNING_MESSAGE);
        }
        switch (fromUnit) {
            case "Atomic Mass Unit":
                if (toUnit == "Carat") {
                    value = value * 8.302700999e-24;
                } else if (toUnit == "Kilogram") {
                    value = value * 1.66053892e-27;
                } else if (toUnit == "Ounce") {
                    value = value * 5.85738796e-26;
                } else if (toUnit == "Pound") {
                    value = value * 3.660867475e-27;
                } else if (toUnit == "Metric Ton") {
                    value = value * 1.660540199e-30;
                } else if (toUnit == "Milligram") {
                    value = value * 1.660540199e-21;
                } else if(toUnit == "Gram") {
                    value = value * 1.660540199e-24;
                } 
                break;
                

            case "Carat":
                if (toUnit == "Atomic Mass Unit") {
                    value = value * 1.20442733e23;
                } else if (toUnit == "Kilogram") {
                    value = value * 0.0002;
                } else if (toUnit == "Ounce") {
                    value = value * 0.0070547981;
                } else if (toUnit == "Pound") {
                    value = value * 0.0004409249;
                } else if (toUnit == "Metric Ton") {
                    value = value * 2.e-7;
                } else if (toUnit == "Milligram") {
                    value = value * 200.0;
                } else if(toUnit == "Gram") {
                    value = value * 0.2;
                }
                break;

            case "Kilogram":
                if (toUnit == "Atomic Mass Unit") {
                    value = value * 6.022136652e26;
                } else if (toUnit == "Carat") {
                    value = value * 5000;
                } else if (toUnit == "Ounce") {
                    value = value * 35.273990723;
                } else if (toUnit == "Pound") {
                    value = value * 2.2046244202;
                } else if (toUnit == "Metric Ton") {
                    value = value * 0.001;
                } else if (toUnit == "Milligram") {
                    value = value * 1000000;
                } else if(toUnit == "Gram") {
                    value = value * 1000;
                }
                break;

            case "Metric Ton":
                if (toUnit == "Atomic Mass Unit") {
                    value = value * 6.022136652e+29;
                } else if (toUnit == "Carat") {
                    value = value * 5000000;
                } else if (toUnit == "Kilogram") {
                    value = value * 1000;
                } else if (toUnit == "Ounce") {
                    value = value * 35273.990723;
                } else if (toUnit == "Pound") {
                    value = value * 2204.6244202;
                } else if (toUnit == "Milligram") {
                    value = value * 1000000000;
                } else if (toUnit == "Gram") {
                    value = value * 1000000;
                }
                break;

            case "Pound":
                if (toUnit == "Atomic Mass Unit") {
                    value = value * 2.731593008e+26;
                } else if (toUnit == "Carat") {
                    value = value * 2267.96;
                } else if (toUnit == "Kilogram") {
                    value = value * 0.453592;
                } else if (toUnit == "Ounce") {
                    value = value * 16;
                } else if (toUnit == "Milligram") {
                    value = value * 453592;
                } else if (toUnit == "Metric Ton") {
                    value = value * 0.000453592;
                } else if (toUnit == "Gram") {
                    value = value * 453.592;
                }
                break;
            
            case "Milligram":
                if (toUnit == "Atomic Mass Unit") {
                    value = value * 1.66053892e-27;
                    value = value * 1000000;
                } else if (toUnit == "Carat") {
                    value = value * 0.005;
                } else if (toUnit == "Kilogram") {
                    value = value * 0.000001;
                } else if (toUnit == "Ounce") {
                    value = value * 0.000035274;
                } else if (toUnit == "Pound") {
                    value = value * 0.0000022046;
                } else if (toUnit == "Metric Ton") {
                    value = value * 9.999999999E-10;
                } else if (toUnit == "Gram") {
                    value = value * 0.001;
                }
                break;
            
            case "Ounce":
                if (toUnit == "Atomic Mass Unit") {
                    value = value * 1.70724563e+25;
                } else if (toUnit == "Carat") {
                    value = value * 141.7475;
                } else if (toUnit == "Kilogram") {
                    value = value * 0.0283495;
                } else if (toUnit == "Milligram") {
                    value = value * 28349.5;
                } else if (toUnit == "Pound") {
                    value = value * 0.0625;
                } else if (toUnit == "Metric Ton") {
                    value = value * 0.0000283495;
                } else if (toUnit == "Gram") {
                    value = value * 28.3495;
                }
                break;

        }
        toField.setText("Result: "+value);
    }

    public static void main(String [] argc) {
        SwingUtilities.invokeLater(() -> new UnitConverter());
    }
}